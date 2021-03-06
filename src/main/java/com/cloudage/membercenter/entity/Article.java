package com.cloudage.membercenter.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import com.cloudage.membercenter.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Article extends BaseEntity {
	
	User author;
	Date createDate;
	Date editDate;

	String title;
	String text;
	
	@ManyToOne(optional=false)
	@JsonIgnore//加上这个当从后台推数据到前台是会忽略掉user这个属性
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Column(updatable=false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@PreUpdate
	void onPreUpdate(){
		editDate = new Date();
	}
	
	@PrePersist
	void onPrePersist(){
		createDate = new Date();
		editDate = new Date();
	}
	
	
	@Transient
	public String getAuthorAvatar(){
		return author.avatar;
	}
	

}