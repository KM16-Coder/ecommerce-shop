package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity extends BaseEntity {
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@OneToMany(mappedBy="category",fetch = FetchType.LAZY,orphanRemoval = true)
	private List<ProductEntity> products=new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="categorygender_id")
	private CategoryGenderEntity categoryGender;
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
	public List<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	public CategoryGenderEntity getCategoryGender() {
		return categoryGender;
	}
	public void setCategoryGender(CategoryGenderEntity categoryGender) {
		this.categoryGender = categoryGender;
	}
	
	
	 
}
