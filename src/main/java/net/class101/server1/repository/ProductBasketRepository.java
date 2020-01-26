package net.class101.server1.repository;

import java.util.ArrayList;
import java.util.List;

import net.class101.server1.entity.ProductBasket;

public class ProductBasketRepository {

	private List<ProductBasket> productBaskets = new ArrayList<>();
	private long totalPrice;

	private ProductBasketRepository(){}
	
	private static class SingleTonHolder{
        private static final ProductBasketRepository instance = new ProductBasketRepository();
    }
     
    public static ProductBasketRepository getInstance(){
        return SingleTonHolder.instance;
    }

	public List<ProductBasket> findAll() {
		return productBaskets;
	}

	public long sumAllPrice() {
		return totalPrice;
	}
	
	public void save(List<ProductBasket> productBaskets) {
		this.productBaskets.addAll(productBaskets);
		for (ProductBasket productBasket : productBaskets) {
			totalPrice += (productBasket.getProduct().getPrice() * productBasket.getAmount());
		}
	}
	
	public boolean hasDeliveryFee() {
		if (totalPrice < 50000) {
			return true;
		}
		return false;
	}

	public void deleteAll() {
		productBaskets.clear();
		totalPrice = 0;
	}

}
