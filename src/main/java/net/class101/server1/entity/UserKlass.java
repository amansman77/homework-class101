package net.class101.server1.entity;

import java.time.LocalDateTime;

public class UserKlass {

	private Product product;
	private LocalDateTime registDateTime;
	
	public UserKlass() {
	}
	public UserKlass(Product product) {
		this.product = product;
		this.setRegistDateTime(LocalDateTime.now());
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public LocalDateTime getRegistDateTime() {
		return registDateTime;
	}
	public void setRegistDateTime(LocalDateTime registDateTime) {
		this.registDateTime = registDateTime;
	}
	
}
