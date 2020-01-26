package net.class101.server1.entity;

public class ProductBasket {

	private Product product;
	private long amount;
	
	public ProductBasket() {
	}
	public ProductBasket(Product product, long amount) {
		this.product = product;
		this.amount = amount;
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
