package com.cloudage.membercenter.service;

import com.cloudage.membercenter.entity.Bill;
import com.cloudage.membercenter.entity.Wallet;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface IBillService {
    Bill save(Bill bill);
    Page<Bill> findByUserId(int user_id,int page);

}
