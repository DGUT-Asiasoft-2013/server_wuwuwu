package com.cloudage.membercenter.repository;

import com.cloudage.membercenter.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface IBillRepository extends PagingAndSortingRepository<Bill,Integer> {
    @Query("from Bill bill where bill.user.id=?1")
    Page<Bill> findByUserId(Integer user_id, Pageable pageable);

}
