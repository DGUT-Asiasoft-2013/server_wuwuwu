package com.cloudage.membercenter.controller;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.Collections;
import com.cloudage.membercenter.entity.Comment;
import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IArticleService;
import com.cloudage.membercenter.service.ICollectionsService;
import com.cloudage.membercenter.service.ICommentService;
import com.cloudage.membercenter.service.ICommodityService;
import com.cloudage.membercenter.service.ILikesService;
import com.cloudage.membercenter.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	IUserService userService;

	@Autowired
	ICommodityService commodityService;

	@Autowired
	ICollectionsService collectionsService;



	@Autowired
	IArticleService articleService;

	@Autowired
	ICommentService commentService;

	@Autowired
	ILikesService likesService;


	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public @ResponseBody String hello(){
		return "HELLO WORLD";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public User register(
			@RequestParam String account,
			@RequestParam String passwordHash,
			@RequestParam String telephone,
			@RequestParam String nickname,
			@RequestParam String address,
			@RequestParam Integer money,
			MultipartFile avatar,
			HttpServletRequest request){

		User user = new User();
		user.setAccount(account);
		user.setPasswordHash(passwordHash);
		user.setTelephone(telephone);
		user.setNickname(nickname);
		user.setAddress(address);
		user.setMoney(money);


		if(avatar!=null){
			try{
				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				FileUtils.copyInputStreamToFile(avatar.getInputStream(), new File(realPath,account+".png"));
				user.setAvatar("upload/"+account+".png");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return userService.save(user);
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public User login(
			@RequestParam String account,
			@RequestParam String passwordHash,
			HttpServletRequest request){

		User user = userService.findByAccount(account);
		if(user!=null && user.getPasswordHash().equals(passwordHash)){
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", user.getId());
			return user;
		}else{
			return null;
		}
	}

	@RequestMapping(value="/me", method=RequestMethod.GET)
	public User getCurrentUser(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		Integer uid = (Integer) session.getAttribute("uid");
		return userService.findById(uid);
	}

	@RequestMapping(value="/passwordrecover", method=RequestMethod.POST)
	public boolean resetPassword(
			@RequestParam String telephone,
			@RequestParam String passwordHash
			){
		User user = userService.findByTelephone(telephone);
		if(user==null){
			return false;
		}else{
			user.setPasswordHash(passwordHash);
			userService.save(user);
			return true;
		}
	}

	@RequestMapping(value="/articles/{userId}")
	public List<Article> getArticlesByUserID(@PathVariable Integer userId){
		return articleService.findAllByAuthorId(userId);
	}

	@RequestMapping(value="/article",method=RequestMethod.POST)
	public Article addArticle(
			@RequestParam String title,
			@RequestParam String text,
			HttpServletRequest request){
		User currentUser = getCurrentUser(request);
		Article article = new Article();
		article.setAuthor(currentUser);
		article.setTitle(title);
		article.setText(text);
		return articleService.save(article);
	}

	@RequestMapping("/feeds/{page}")
	public Page<Article> getFeeds(@PathVariable int page){
		return articleService.getFeeds(page);
	}

	@RequestMapping("/feeds")
	public Page<Article> getFeeds(){
		return getFeeds(0);
	}

	@RequestMapping("/article/{article_id}/comments/{page}")
	public Page<Comment> getCommentsOfArticle(
			@PathVariable int article_id,
			@PathVariable int page){
		return commentService.findCommentsOfArticle(article_id, page);
	}

	@RequestMapping("/article/{article_id}/comments/count")
	public int getCommentsCountOfArticle(@PathVariable int article_id){
		return commentService.getCommentCountOfArticle(article_id);
	}

	@RequestMapping("/article/{article_id}/comments")
	public Page<Comment> getCommentsOfArticle(
			@PathVariable int article_id){
		return commentService.findCommentsOfArticle(article_id, 0);
	}

	@RequestMapping(value = "/article/{article_id}/comments", method = RequestMethod.POST)
	public Comment postComment(
			@PathVariable int article_id,
			@RequestParam String text,
			HttpServletRequest request){
		User me = getCurrentUser(request);
		Article article = articleService.findOne(article_id);
		Comment comment = new Comment();
		comment.setAuthor(me);
		comment.setArticle(article);
		comment.setText(text);
		return commentService.save(comment);
	}

	@RequestMapping("/article/{article_id}/likes")
	public int countLikes(@PathVariable int article_id){
		return likesService.countLikes(article_id);
	}

	@RequestMapping("/article/{article_id}/isliked")
	public boolean checkLiked(@PathVariable int article_id,HttpServletRequest request){
		User me = getCurrentUser(request);
		return likesService.checkLiked(me.getId(), article_id);
	}

	@RequestMapping(value="/article/{article_id}/likes",method = RequestMethod.POST)
	public int changeLikes(
			@PathVariable int article_id,
			@RequestParam boolean likes,
			HttpServletRequest request
			){
		User me = getCurrentUser(request);
		Article article = articleService.findOne(article_id);

		if(likes)
			likesService.addLike(me, article);
		else
			likesService.removeLike(me, article);

		return likesService.countLikes(article_id);
	}



	@RequestMapping("/commodity/{commodity_id}/collect")
	public int countCollections(@PathVariable int commodity_id){
		return collectionsService.countCollections(commodity_id);
	}



	@RequestMapping("/commodity/{commodity_id}/iscollected")
	public boolean checkCollected(@PathVariable int commodity_id,HttpServletRequest request){
		User me = getCurrentUser(request);
		return collectionsService.checkCollectioned(me.getId(), commodity_id);
	}






	@RequestMapping(value="/commodity/{commodity_id}/collect",method = RequestMethod.POST)
	public int changeCollects(
			@PathVariable int commodity_id,
			@RequestParam boolean collect,
			HttpServletRequest request
			){
		User me = getCurrentUser(request);
		Commodity commodity = commodityService.findOne(commodity_id);

		if(collect)
			collectionsService.addCollection(me, commodity);
		else
			collectionsService.removeCollection(me, commodity);

		return collectionsService.countCollections(commodity_id);
	}

	@RequestMapping(value="/collections")
	public Page<Collections> getMyComments(
			HttpServletRequest request
			){
		//	 		return collectionsService.getMyCollections(getCurrentUser(request).getId(),0);


		return collectionsService.getMyCollections(44,0);
	}

	@RequestMapping(value="/collections/{page}")
	public Page<Collections> getMycollections(
			@PathVariable int page,
			HttpServletRequest request
			){
		return collectionsService.getMyCollections(getCurrentUser(request).getId(),page);
	}




	@RequestMapping(value="/commodity/{userId}")
	public List<Commodity> getCommodityByUserID(@PathVariable Integer userId){
		return commodityService.findAllByUserId(userId);
	}

	//发布
	@RequestMapping(value = "/commodity",method = RequestMethod.POST)
	public Commodity addCommodity(
			@RequestParam String CommName,
			@RequestParam String CommPrice,
			@RequestParam int CommNumber,
			@RequestParam String CommDescrible,
			MultipartFile CommImage,
			HttpServletRequest request){
		User currentuser = getCurrentUser(request);
		Commodity commodity = new Commodity();
		commodity.setUser(currentuser);
		commodity.setCommName(CommName);
		commodity.setCommPrice(CommPrice);
		commodity.setCommNumber(CommNumber);
		commodity.setCommDescribe(CommDescrible);

		if(CommImage!=null){
			try{
				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/commodity");
				FileUtils.copyInputStreamToFile(CommImage.getInputStream(), new File(realPath,CommName+".png"));
				commodity.setCommImage("commodity/"+CommName+".png");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return commodityService.save(commodity);

	}

	@RequestMapping("/home/{page}")
	public Page<Commodity> getHome(@PathVariable int page){
		return commodityService.getHome(page);
	}

	@RequestMapping("/home")
	public Page<Commodity> getHomes(){
		return getHome(0);
	}
}