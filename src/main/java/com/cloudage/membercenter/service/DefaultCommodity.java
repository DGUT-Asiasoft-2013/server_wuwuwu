package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloudage.membercenter.repository.ICommodityRepository;

public class DefaultCommodity implements ICommodityService{
	@Autowired
	ICommodityRepository commodityRepo;

}
