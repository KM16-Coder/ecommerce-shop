package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity extends BaseEntity {
	@Column(name="name")
	private String name;
	@Column(name="productcode")
	private String productCode;
	@Column(name="title")
	private String title;
	@Column(name="thumbnail")
	private String thumbnail;
	@Column(name="shortdescription",columnDefinition = "TEXT")
	private String shortDescription;
	@Column(name="content",columnDefinition = "TEXT")
	private String content;
	@Column(name="color")
	private String color;
	@Column(name="size")
	private Integer size;
	@Column(name="price")
	private Long price;
	@Column(name="countinput")
	private Integer countInput;
	@Column(name="saleoff")
	private Double saleOff;
	@Column(name="status")
	private int status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private CategoryEntity category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="store_id")
	private StoreEntity storeEntity;
	
	
	@ManyToMany(mappedBy="products",fetch = FetchType.LAZY)
	private List<UserEntity> users=new ArrayList<>();
	
	@OneToMany(mappedBy="product",fetch = FetchType.LAZY,orphanRemoval = true)
	private List<ImageEntity> images=new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getCountInput() {
		return countInput;
	}
	public void setCountInput(Integer countInput) {
		this.countInput = countInput;
	}
	public Double getSaleOff() {
		return saleOff;
	}
	public void setSaleOff(Double saleOff) {
		this.saleOff = saleOff;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public CategoryEntity getCategoryEntity() {
		return category;
	}
	public void setCategoryEntity(CategoryEntity category) {
		this.category = category;
	}
	
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public StoreEntity getStoreEntity() {
		return storeEntity;
	}
	public void setStoreEntity(StoreEntity storeEntity) {
		this.storeEntity = storeEntity;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	public List<ImageEntity> getImages() {
		return images;
	}
	public void setImages(List<ImageEntity> images) {
		this.images = images;
	}
	
	
}
