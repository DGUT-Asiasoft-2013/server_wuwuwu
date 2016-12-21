package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.Collections;
import com.cloudage.membercenter.entity.Collections.Key;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.ICollectionsRepository;

@Component
@Service
@Transactional
public class DefaultCollectionsService implements ICollectionsService {

	@Autowired
	ICollectionsRepository collectionsRepo;

	@Override
	public void addCollection(User user, Commodity commodity) {
		Collections.Key key = new Key();
		key.setUser(user);
		key.setCommodity(commodity);

		Collections lk = new Collections();
		lk.setId(key);
		collectionsRepo.save(lk);
	}

	@Override
	public void removeCollection(User user, Commodity commodity) {
		Collections.Key key = new Key();
		key.setUser(user);
		key.setCommodity(commodity);

		collectionsRepo.delete(key);
	}

	@Override
	public int countCollections(int commodityId) {
		return collectionsRepo.collectionsCountsOfCommodity(commodityId);
	}

	@Override
	public boolean checkCollectioned(int userId, int commodityId) {
		return collectionsRepo.checkCollectionsExsists(userId, commodityId)>0;
	}
	 	
	 	@Override
	 	public Page<Collections> getMyCollections(Integer id,int page) {
	 		Sort sort = new Sort(Direction.DESC, "createDate");
	 		PageRequest pageReqeust = new PageRequest(page, 10, sort);
	 		return collectionsRepo.findAllOfMy(id, pageReqeust);
	 	}

}
