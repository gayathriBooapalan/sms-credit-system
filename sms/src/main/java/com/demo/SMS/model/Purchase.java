package com.demo.SMS.model;

import java.util.Date;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="PurchaseCredit")
public class Purchase {
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ph_Number")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	long id;
	
	@Column(name="Pur_Date")
	private LocalDate purchasedate;
	public LocalDate getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(LocalDate purchasedate) {
		this.purchasedate = purchasedate;
	}
	public int getCreditPoints() {
		return creditPoints;
	}
	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate2) {
		this.expiryDate = expiryDate2;
	}
	@Column(name="cred_Pts")
	private int creditPoints;
	@Column(name="exp_Date")
	private LocalDate expiryDate;

}
