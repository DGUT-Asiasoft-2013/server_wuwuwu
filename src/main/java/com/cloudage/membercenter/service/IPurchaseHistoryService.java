package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.PurchaseHistory;

public interface IPurchaseHistoryService {

	PurchaseHistory save(PurchaseHistory purchaseHistory);

	Page<PurchaseHistory> getOrderFeeds(int page);
}
