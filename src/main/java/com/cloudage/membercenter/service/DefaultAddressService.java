package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Address;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IAddressRepository;

@Component
@Service
@Transactional
public class DefaultAddressService implements IAddressService{
	@Autowired
	IAddressRepository addressRepo;

	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}



	@Override
	public List<Address> findByUser(User user) {
		// TODO Auto-generated method stub
		return addressRepo.findByUser(user);
	}



	@Override
	public List<Address> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return addressRepo.findByUserId(userId);
	}



	@Override
	public void deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		addressRepo.delete(id);
	}



	@Override
	public Address findDefaultOfUser(Integer userId) {
		// TODO Auto-generated method stub
		return addressRepo.findDefaultAddressOfUser(userId);
	}



	@Override
	public Address findAddressByID(Integer addressId) {
		// TODO Auto-generated method stub
		return addressRepo.findOne(addressId);
	}







}
