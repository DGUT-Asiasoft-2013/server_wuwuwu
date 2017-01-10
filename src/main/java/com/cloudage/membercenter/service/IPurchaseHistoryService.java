package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.PurchaseHistory;

public interface IPurchaseHistoryService {

	PurchaseHistory save(PurchaseHistory purchaseHistory);

	List<PurchaseHistory> findByUserId(Integer userId);
	Page<PurchaseHistory> getOrderFeeds(int page);
}
