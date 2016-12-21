package com.cloudage.membercenter.service;

import com.cloudage.membercenter.entity.Bill;
import com.cloudage.membercenter.entity.Wallet;
import com.cloudage.membercenter.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by Administrator on 2016/12/19.
 */
public class DefaultBillService implements IBillService {
    @Autowired
    IBillRepository billRepository;

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Page<Bill> findByUserId(int user_id, int page) {
            Sort sort = new Sort(Sort.Direction.DESC, "createDate");
            PageRequest pageReqeust = new PageRequest(page, 10, sort);
            return billRepository.findByUserId(user_id,pageReqeust);
    }


}
