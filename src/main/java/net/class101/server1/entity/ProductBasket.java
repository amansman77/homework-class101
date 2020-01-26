package net.class101.server1.entity;

public class ProductBasket {

	private String userId;
	private Product product;
	private long amount;
	
	public ProductBasket() {
	}
	public ProductBasket(String userId, Product product, long amount) {
		this.userId = userId;
		this.product = product;
		this.amount = amount;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
