package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Address;
import com.cloudage.membercenter.entity.Bill;
import com.cloudage.membercenter.entity.User;

public interface IAddressRepository extends PagingAndSortingRepository<Address,Integer>{
	@Query("from Address address where address.user=?1")
	List<Address> findByUser(User user);

	@Query("from Address address where address.user.id=?1")
	List<Address> findByUserId(Integer userId);


}
