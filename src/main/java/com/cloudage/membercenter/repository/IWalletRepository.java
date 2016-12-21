package com.cloudage.membercenter.repository;

import com.cloudage.membercenter.entity.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface IWalletRepository extends PagingAndSortingRepository<Wallet,Integer> {
    @Query("from Wallet wallet where wallet.user.id=?1")
    Wallet findByUserId(Integer user_id);

}
