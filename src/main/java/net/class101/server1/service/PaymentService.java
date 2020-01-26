package net.class101.server1.service;

import net.class101.server1.repository.ProductBasketRepository;
import net.class101.server1.repository.ProductRepository;

public class PaymentService {

	private ProductRepository productRepository = ProductRepository.getInstance();
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

	public void processPayment() {
	}
	
}
