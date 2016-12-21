package com.cloudage.membercenter.entity;

import com.cloudage.membercenter.util.DateRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Created by Administrator on 2016/12/19.
 */
public class Bill extends DateRecord {
    User user;
    String description;

    @ManyToOne(optional=false)
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Transient
    public int getUserId(){return user.getId();}
}
