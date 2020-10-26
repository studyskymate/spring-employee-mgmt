package com.dinesh.emp.model;


public class Product {
	
	private long id;
	private String name;
	private String price;
	private String imageUrl;
	
	
	public Product(long id, String name, String price) {
		this.id = id;
		this.name = name;
		this.price = price;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
