package com.cloudage.membercenter.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.cloudage.membercenter.util.DateRecord;

@Entity
public class Need extends DateRecord {
	
	User user;

	String title;
	String content;
	
	Date endDate;
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@ManyToOne(optional=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}