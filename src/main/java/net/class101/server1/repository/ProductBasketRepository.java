package net.class101.server1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.class101.server1.entity.ProductBasket;

public class ProductBasketRepository {

	private List<ProductBasket> productBaskets = new ArrayList<>();

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

	public List<ProductBasket> findByUserId(String userId) {
		return productBaskets.stream().filter(p -> p.getUserId().equals(userId)).collect(Collectors.toList());
	}

	public long sumPriceByUserId(String userId) {
		long totalPrice = 0;
		
		List<ProductBasket> findProductBaskets = productBaskets.stream().filter(p -> p.getUserId().equals(userId)).collect(Collectors.toList());
		for (ProductBasket productBasket : findProductBaskets) {
			totalPrice += productBasket.getProduct().getPrice() * productBasket.getAmount();
		}
		return totalPrice;
	}
	
	public void save(List<ProductBasket> productBaskets) {
		this.productBaskets.addAll(productBaskets);
	}
	
	public boolean hasDeliveryFee(String userId) {
		if (this.sumPriceByUserId(userId) < 50000) {
			return true;
		}
		return false;
	}

	public void deleteByUserId(String userId) {
		for (int i = 0; i < this.productBaskets.size(); i++) {
			if (this.productBaskets.get(i).getUserId().equals(userId)) {
				this.productBaskets.remove(i--);
			}
		}
	}

}
