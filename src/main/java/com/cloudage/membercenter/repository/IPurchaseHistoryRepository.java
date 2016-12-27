package com.cloudage.membercenter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.PurchaseHistory;

public interface IPurchaseHistoryRepository extends PagingAndSortingRepository<PurchaseHistory, Integer> {

}
