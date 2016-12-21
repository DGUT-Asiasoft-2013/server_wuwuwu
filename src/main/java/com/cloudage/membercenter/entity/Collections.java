package com.cloudage.membercenter.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.cloudage.membercenter.entity.Likes.Key;
@Entity
public class Collections {
	@Embeddable
	public static class Key implements Serializable{
		User user;
		Commodity commodity;
		
		@ManyToOne(optional=false)
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		@ManyToOne(optional=false)
		public Commodity getCommodity() {
			return commodity;
		}
		public void setCommodity(Commodity commodity) {
			this.commodity = commodity;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Key){
				Key other = (Key)obj;
				return commodity.getId() == other.commodity.getId() && user.getId() == other.user.getId();
			}else{
				return false;
			}
		}

		@Override
		public int hashCode() {
			return commodity.getId();
		}	
	}

	

	Key id;
	Date createDate;

	@Column(updatable=false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@EmbeddedId
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	@PrePersist
	void onPrePersist(){
		createDate = new Date();
	}
}
