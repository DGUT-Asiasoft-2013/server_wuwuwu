package com.cloudage.membercenter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Commodity;

public interface ICommodityRepository extends PagingAndSortingRepository<Commodity, Integer>{

}
