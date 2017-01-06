package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;

public interface ICommodityService {
	List<Commodity> findAllByUser(User user);
	List<Commodity> findAllByUserId(Integer userId);


	//	搜索
	Page<Commodity> searchCommodtyWithKeyword(String keyword, int page,String howsort);


	Commodity findOne(int commodity_id);

	Commodity save(Commodity commodity);

	Page<Commodity> getHome(int page);
	
	//书的分类
	Page<Commodity> getType(int page);
	
	Page<Commodity> findBook(String type, int page);

}
