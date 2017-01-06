package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudage.membercenter.entity.Address;

public interface IAddressService {
	Address save(Address address);
	Page<Address> findByUserId(int user_id,int page);

}
