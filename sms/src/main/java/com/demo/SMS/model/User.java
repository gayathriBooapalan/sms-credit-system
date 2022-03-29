package com.demo.SMS.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="user")
public class User {
	
	@Column(name="ph_number",length=10)
	@Id
	private int phoneNumber;
	
	@OneToOne(mappedBy="Purchase",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getCreditFlag() {
		return creditFlag;
	}
	public void setCreditFlag(Boolean creditFlag) {
		this.creditFlag = creditFlag;
	}
	@Column(name="user_name")
	private String userName;
	@Column(name="credit_flag")
	private Boolean creditFlag;
	
	

}
