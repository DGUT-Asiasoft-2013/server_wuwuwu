package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.Collections;

@Repository
public interface ICollectionsRepository extends PagingAndSortingRepository<Collections, Collections.Key> {

	@Query("select count(*) from Collections collections where collections.id.commodity.id = ?1")
	int collectionsCountsOfCommodity(int commodityId);

	@Query("select count(*) from Collections collections where collections.id.user.id = ?1 and collections.id.commodity.id = ?2")
	int checkCollectionsExsists(int authorId, int commodityId);

	@Query("from Collections collections where collections.id.user.id = ?1")
	Page<Collections> findAllOfMy(Integer id,Pageable page);
}
