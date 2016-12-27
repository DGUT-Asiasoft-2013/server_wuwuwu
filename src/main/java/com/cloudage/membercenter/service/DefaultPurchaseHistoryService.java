package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
