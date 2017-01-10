package com.cloudage.membercenter.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;


import com.cloudage.membercenter.entity.Need;
import com.cloudage.membercenter.entity.User;

public interface INeedService {
	List<Need> findAllByUser(User user);
	List<Need> findAllByUserId(Integer userId);


	//	搜索
	Page<Need> searchNeedWithKeyword(String keyword, int page);


	Need findOne(int need_id);

	Need save(Need need);
	Page<Need> getNeeds(int page);



}
