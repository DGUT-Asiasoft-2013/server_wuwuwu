package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.cloudage.membercenter.util.BaseEntity;

@Entity
public class User extends BaseEntity{
	String account;
	String passwordHash;
	String nickname;
	String telephone;
	String avatar;
	
	@Column(unique=true)
	public String getAccount() {
		return account;
	}
	
	@Column(nullable=false)
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