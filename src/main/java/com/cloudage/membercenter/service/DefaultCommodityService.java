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
import com.cloudage.membercenter.repository.ICommodityRepository;

@Component
@Service
@Transactional
public class DefaultCommodityService implements ICommodityService{
	@Autowired
	ICommodityRepository commodityRepo;

	
//	搜索
	@Override
	public Page<Commodity> searchCommodtyWithKeyword(String keyword, int page) {
		Sort sort = new Sort(Direction.DESC,"createDate");
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



}
