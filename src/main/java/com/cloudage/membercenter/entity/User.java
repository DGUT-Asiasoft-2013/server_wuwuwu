package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.cloudage.membercenter.util.BaseEntity;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class User extends BaseEntity{
	String account;
	String passwordHash;
	String nickname;
	String telephone;
	String avatar;
	Integer money;

	@ColumnDefault("0")
	//return money==null? 0 : money;
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Column(unique=true)//该字段是否为唯一标识
	public String getAccount() {
		return account;
	}
	
	@Column(nullable=false)//是否能为空
	public String getPasswordHash() {
		return passwordHash;
	}
	
	@Column(unique=true)
	public String getNickname() {
		return nickname;
	}
	
	@Column(nullable=true)
	public String getAvatar() {
		return avatar;
	}

	@Column(nullable=false,unique=true)
	public String getTelephone() {
		return telephone;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}