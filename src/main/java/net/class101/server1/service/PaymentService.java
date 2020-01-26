package net.class101.server1.service;

import java.util.List;

import net.class101.server1.entity.ProductBasket;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.repository.ProductBasketRepository;

public class PaymentService {

	private ProductBasketRepository productBasketRepository = ProductBasketRepository.getInstance();
	
	private PaymentService(){}
    
    private static class SingleTonHolder{
        private static final PaymentService instance = new PaymentService();
    }
     
    public static PaymentService getInstance(){
        return SingleTonHolder.instance;
    }
    
	public long getTotalPrice() {
		return productBasketRepository.sumAllPrice()
				+ (productBasketRepository.hasDeliveryFee()?5000:0);
	}

	synchronized public void processPayment() throws SoldOutException {
		List<ProductBasket> findProductBaskets = productBasketRepository.findAll();
		for (ProductBasket productBasket : findProductBaskets) {
			if (productBasket.getAmount() > productBasket.getProduct().getAmount()) {
				throw new SoldOutException();
			}
		}
		
		for (ProductBasket productBasket : findProductBaskets) {
			productBasket.getProduct().setAmount(
					productBasket.getProduct().getAmount() - productBasket.getAmount()
					);
		}
		
		productBasketRepository.deleteAll();
	}
	
}
