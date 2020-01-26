package net.class101.server1.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import net.class101.server1.entity.Product;
import net.class101.server1.entity.ProductBasket;
import net.class101.server1.exception.HasKlassException;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.repository.ProductBasketRepository;
import net.class101.server1.repository.ProductRepository;

public class User1Thread implements Runnable {

	@Override
	public void run() {
		ProductRepository productRepository = ProductRepository.getInstance();
		ProductBasketRepository productBasketRepository = ProductBasketRepository.getInstance();
		PaymentService paymentService = PaymentService.getInstance();
		
		Product testProduct = productRepository.findByProductNumber("39712");
		
		productBasketRepository.save(List.of(
				new ProductBasket("user1", testProduct, 8)
				));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			fail("Thread sleep exception");
		}
		
		boolean isOccurException = false;
		try {
			paymentService.processPayment("user1");
		} catch (SoldOutException e) {
			isOccurException = true;
		} catch (HasKlassException e) {
			fail("HasKlassException is not expected");
		}
		
		assertTrue(isOccurException);
		assertTrue("Finish order user1", true);
	}

}
