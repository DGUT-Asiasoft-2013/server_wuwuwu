package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Address;
import com.cloudage.membercenter.entity.Bill;

public interface IAddressRepository extends PagingAndSortingRepository<Address,Integer>{
	@Query("from Address address where address.user.id=?1")
	Page<Address> findByUserId(Integer user_id,Pageable pageable);
}
