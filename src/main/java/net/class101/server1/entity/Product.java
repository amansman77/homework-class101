package net.class101.server1.entity;

public class Product {

	private long sn;
	private String number;
	private String type;
	private String title;
	private long price;
	private long amount;
	
	public Product() {
	}

	public Product(long sn, String number, String type, String title, long price, long amount) {
		this.sn = sn;
		this.number = number;
		this.type = type;
		this.title = title;
		this.price = price;
		this.price = price;
		this.amount = amount;
	}

	public long getSn() {
		return sn;
	}

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public long getPrice() {
		return price;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
