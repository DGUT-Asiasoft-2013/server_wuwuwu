package com.cloudage.membercenter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.cloudage.membercenter.util.BaseEntity;

@Entity
public class PurchaseHistory extends BaseEntity{

	User user;
	Integer commodity_Id; 
	Date createDate; //购买日期
	int buyNumber;  //购买数量
	int totalPrice; //总价
	int commodityPrice;

	
	
	@ManyToOne(optional=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCommodity_Id() {
		return commodity_Id;
	}
	public void setCommodity_Id(Integer commodity_Id) {
		this.commodity_Id = commodity_Id;
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

	
	public int getCommodityPrice(){ //商品单价
		return commodityPrice;
	}

	

	public void setCommodityPrice(int commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	@PrePersist
	void onPrePersist(){
		createDate = new Date();

	}
}
