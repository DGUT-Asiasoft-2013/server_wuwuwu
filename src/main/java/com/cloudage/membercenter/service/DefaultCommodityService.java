package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.ICommodityRepository;

@Component
@Service
@Transactional
public class DefaultCommodityService implements ICommodityService{
	@Autowired
	ICommodityRepository commodityRepo;


	//	搜索
	@Override

	public Page<Commodity> searchCommodtyWithKeyword(String keyword, int page,String howsort) {
		Sort sort;
		if(howsort.equals("time")){
			sort = new Sort(Direction.DESC,"createDate");
		}else if(howsort.equals("highprice")){
			sort = new Sort(Direction.DESC,"commPrice");
		}else if(howsort.equals("lowprice")){
			sort = new Sort(Direction.ASC,"commPrice");
		}else{
			sort = new Sort(Direction.DESC,"createDate");
		}


		PageRequest pageRequest = new PageRequest(page, 10, sort);
		return commodityRepo.searchCommodityWithKeyword(keyword, pageRequest);
	}


	@Override
	public Commodity findOne(int commodity_id) {
		return commodityRepo.findOne(commodity_id);
	}


	@Override
	public Commodity save(Commodity commodity) {
		// TODO Auto-generated method stub
		return commodityRepo.save(commodity);
	}


	@Override
	public Page<Commodity> getHome(int page) {
		Sort sort = new Sort(Direction.DESC,"CommName");
		PageRequest pageRequest = new PageRequest(page, 10);
		return commodityRepo.findAll(pageRequest);
	}





	@Override
	public List<Commodity> findAllByUser(User user) {
		// TODO Auto-generated method stub
		return commodityRepo.findAllByUser(user);
	}


	@Override
	public List<Commodity> findAllByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return commodityRepo.findAllByUserId(userId);
	}



}
