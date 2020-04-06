package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class PurchaseEntity extends BaseEntity {
	@Column(name="username")
	private String userName;
	@Column(name="fullname")
	private String fullName;
	@Column(name="phonenumber")
	private String phoneNumber;
	@Column(name="amount")
	private int amount;
	@Column(name="sumprice")
	private Long sumPrice;
	@Column(name="status")
	private int status;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Long getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Long sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
