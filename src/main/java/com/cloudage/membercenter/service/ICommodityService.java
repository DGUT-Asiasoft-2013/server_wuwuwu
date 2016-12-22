package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.Commodity;

public interface ICommodityService {

//	搜索
	Page<Commodity> searchCommodtyWithKeyword(String keyword, int page);

	Commodity findOne(int commodity_id);

	Commodity save(Commodity commodity);

	Page<Commodity> getHome(int page);


}
