package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="categorygender")
public class CategoryGenderEntity extends BaseEntity {
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@OneToMany(mappedBy="categoryGender",fetch = FetchType.LAZY,orphanRemoval = true)
	private List<CategoryEntity> categorys=new ArrayList<>();;
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
	public List<CategoryEntity> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<CategoryEntity> categorys) {
		this.categorys = categorys;
	}

	
}
