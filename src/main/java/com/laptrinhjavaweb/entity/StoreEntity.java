package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class StoreEntity extends BaseEntity {
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@OneToMany(mappedBy ="storeEntity",fetch = FetchType.LAZY,orphanRemoval = true)
	private List<ProductEntity> productStores=new ArrayList<>();
	
	@OneToOne(mappedBy="storeEntity",orphanRemoval = true)
	ShopEntity shopEntity;
	public List<ProductEntity> getProductStores() {
		return productStores;
	}
	public void setProductStores(List<ProductEntity> productStores) {
		this.productStores = productStores;
	}
	public ShopEntity getShopEntity() {
		return shopEntity;
	}
	public void setShopEntity(ShopEntity shopEntity) {
		this.shopEntity = shopEntity;
	}
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

	
	
	
	
	
}
