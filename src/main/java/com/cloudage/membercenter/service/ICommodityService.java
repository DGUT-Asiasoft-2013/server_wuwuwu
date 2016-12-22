package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;

public interface ICommodityService {
	List<Commodity> findAllByUser(User user);
	List<Commodity> findAllByUserId(Integer userId);

	//	搜索
	Page<Commodity> searchCommodtyWithKeyword(String keyword, int page);

	Commodity findOne(int commodity_id);

	Commodity save(Commodity commodity);



}
