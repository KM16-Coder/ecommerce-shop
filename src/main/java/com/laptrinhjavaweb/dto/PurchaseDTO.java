package com.laptrinhjavaweb.dto;

public class PurchaseDTO extends BaseDTO {
	private String name;
	private String productCode;
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private String color;
	private Integer size;
	private Long price;
	private Integer countInput;
	private Double saleOff;
	private int status;
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
	
	
}
