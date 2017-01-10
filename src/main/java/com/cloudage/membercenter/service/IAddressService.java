package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.cloudage.membercenter.entity.Address;
import com.cloudage.membercenter.entity.User;

public interface IAddressService {
	Address save(Address address);
	Address findDefaultOfUser(Integer userId);
	Address findAddressByID(Integer addressId);
	List<Address> findByUser(User user);
	List<Address> findByUserId(Integer userId);
	void deleteAddress(Integer id);


}
