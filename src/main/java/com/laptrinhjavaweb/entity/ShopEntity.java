package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="shop")
public class ShopEntity extends BaseEntity {
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@Column(name="address")
	private String address;
	@Column(name="status")
	private int status;
	
	@OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinTable(name="shop_store",
			joinColumns = {@JoinColumn(name="shop_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="store_id",referencedColumnName = "id")})
	private StoreEntity storeEntity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public StoreEntity getStoreEntity() {
		return storeEntity;
	}
	public void setStoreEntity(StoreEntity storeEntity) {
		this.storeEntity = storeEntity;
	}

		
	
}
