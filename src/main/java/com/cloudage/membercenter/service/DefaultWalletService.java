package com.cloudage.membercenter.service;

import com.cloudage.membercenter.entity.Wallet;
import com.cloudage.membercenter.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/12/19.
 */
public class DefaultWalletService implements IWalletService {
    @Autowired
    IWalletRepository walletRepository;

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUserId(Integer user_id) {
        return walletRepository.findByUserId(user_id);
    }
}
