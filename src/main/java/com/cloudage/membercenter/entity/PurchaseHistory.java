package com.cloudage.membercenter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.cloudage.membercenter.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PurchaseHistory extends BaseEntity{

	User user;
	Commodity commodity; 
	Date createDate; //购买日期
	int buyNumber;  //购买数量
	int totalPrice; //总价


	@ManyToOne(optional=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getBuyNumber() {
		return buyNumber;
	}

	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@ManyToOne(optional=false)
	public Commodity getCommodity() {
		return commodity;
	}

	
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@PrePersist
	void onPrePersist(){
		createDate = new Date();

	}
}
