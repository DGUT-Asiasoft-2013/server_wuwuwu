package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.PurchaseHistory;

public interface IPurchaseHistoryRepository extends PagingAndSortingRepository<PurchaseHistory, Integer> {

	@Query("from PurchaseHistory purchaseHistory where purchaseHistory.user.id=?1")
	List<PurchaseHistory> findByUserId(Integer userId);

}
