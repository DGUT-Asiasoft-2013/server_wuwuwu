package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.Commodity;

@Repository
public interface ICommodityRepository extends PagingAndSortingRepository<Commodity, Integer>{
	
	
	
	
//	搜索
	@Query("from Commodity commodity where commodity.commName like %?1%")
	 	Page<Commodity> searchCommodityWithKeyword(String keyword,Pageable page);


}
