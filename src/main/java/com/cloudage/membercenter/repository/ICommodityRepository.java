package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;

@Repository
public interface ICommodityRepository extends PagingAndSortingRepository<Commodity, Integer>{
	@Query("from Commodity commodity where commodity.user = ?1")
	List<Commodity> findAllByUser(User user);

	@Query("from Commodity commodity where commodity.user.id = ?1")
	List<Commodity> findAllByUserId(Integer userId);

	@Query("from Commodity commodity where commodity.commName like %?1%")
	Page<Commodity> searchCommodityWithKeyword(String keyword,Pageable page);
	
	
	@Query("from Commodity commodity where commodity.commType like %?1%")
	Page<Commodity> findBook(String type, Pageable page);


}
