package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Collections;
import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;

public interface ICollectionsService {

	void addCollection(User user, Commodity commodity);
	void removeCollection(User user, Commodity commodity);
	int countCollections(int commodityId);
	boolean checkCollectioned(int userId, int commodityId);
	Page<Collections> getMyCollections(Integer id, int page);

}
