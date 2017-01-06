package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Address;
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
	public Page<Address> findByUserId(int user_id, int page) {
		Sort sort = new Sort(Sort.Direction.DESC, "address");
		PageRequest pageReqeust = new PageRequest(page, 10, sort);
		return addressRepo.findByUserId(user_id, pageReqeust);
	}

}
