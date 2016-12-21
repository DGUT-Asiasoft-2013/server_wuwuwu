package com.cloudage.membercenter.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.BaseEntity;
import com.cloudage.membercenter.util.DateRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commodity extends DateRecord{
	User user;
	String CommName;         //商品名称
	String CommPrice;        //商品价格
	int CommNumber;          //商品数量
	String CommDescribe;     //商品描述
	String CommImage;        //商品图片
	            
	
	public int getCommNumber() {
		return CommNumber;
	}
	public void setCommNumber(int commNumber) {
		CommNumber = commNumber;
	}
	@ManyToOne
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCommName() {
		return CommName;
	}
	public void setCommName(String commName) {
		CommName = commName;
	}
	public String getCommPrice() {
		return CommPrice;
	}
	public void setCommPrice(String commPrice) {
		CommPrice = commPrice;
	}
	public String getCommDescribe() {
		return CommDescribe;
	}
	public void setCommDescribe(String commPescribe) {
		CommDescribe = commPescribe;
	}
	public String getCommImage() {
		return CommImage;
	}
	public void setCommImage(String commImage) {
		CommImage = commImage;
	}
	
}
