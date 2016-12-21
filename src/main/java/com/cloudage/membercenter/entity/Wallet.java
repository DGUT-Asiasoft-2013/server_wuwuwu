package com.cloudage.membercenter.entity;

import com.cloudage.membercenter.util.DateRecord;

import javax.persistence.ManyToOne;

/**
 * Created by Administrator on 2016/12/19.
 */
public class Wallet extends DateRecord {
    User user;
    int money;

    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
