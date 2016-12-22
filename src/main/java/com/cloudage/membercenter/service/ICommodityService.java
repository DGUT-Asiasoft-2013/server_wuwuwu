package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.Commodity;

public interface ICommodityService {

//	搜索
	Page<Commodity> searchCommodtyWithKeyword(String keyword, int page,String howsort);

	Commodity findOne(int commodity_id);

}
