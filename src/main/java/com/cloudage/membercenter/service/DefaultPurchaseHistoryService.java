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

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.PurchaseHistory;
import com.cloudage.membercenter.repository.IPurchaseHistoryRepository;

@Component
@Service
@Transactional
public class DefaultPurchaseHistoryService implements IPurchaseHistoryService{

	@Autowired
	IPurchaseHistoryRepository purchaseHRepo;
	
	@Override
	public PurchaseHistory save(PurchaseHistory purchaseHistory) {
		
		return purchaseHRepo.save(purchaseHistory);
	}
	
	@Override
	public Page<PurchaseHistory> getOrderFeeds(int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageRequest = new PageRequest(page, 10, sort);
		return purchaseHRepo.findAll(pageRequest);
	}

	@Override
	public List<PurchaseHistory> findByUserId(Integer userId) {
		
		return purchaseHRepo.findByUserId(userId);
	}

	@Override
	public void deletePurchaseHistory(Integer id) {
		
		purchaseHRepo.delete(id);
	}
	
	

}
