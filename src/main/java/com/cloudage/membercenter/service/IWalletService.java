package com.cloudage.membercenter.service;

import com.cloudage.membercenter.entity.Wallet;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface IWalletService {
    Wallet save(Wallet wallet);
    Wallet findByUserId(Integer user_id);

}
