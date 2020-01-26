package net.class101.server1.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import net.class101.server1.entity.Product;
import net.class101.server1.entity.ProductBasket;
import net.class101.server1.exception.HasKlassException;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.repository.ProductBasketRepository;
import net.class101.server1.repository.ProductRepository;

public class PaymentServiceTest {

	@Test
	public void testAsyncSoldOut() {
		User1Thread user1Thread = new User1Thread();
		Thread thread1 = new Thread(user1Thread, "첫번째 사용자");

		thread1.start();
		
		User2Thread user2Thread = new User2Thread();
		Thread thread2 = new Thread(user2Thread, "두번째 사용자");

		thread2.start();
	}
	
//	@Test(expected=SoldOutException.class)
	public void testSoldOutException() throws SoldOutException {
		ProductRepository productRepository = ProductRepository.getInstance();
		ProductBasketRepository productBasketRepository = ProductBasketRepository.getInstance();
		PaymentService paymentService = PaymentService.getInstance();
		
		Product testProduct = productRepository.findByProductNumber("91008");
		
		// 사용자1, 장바구니 추가
		productBasketRepository.save(List.of(
				new ProductBasket("user3", testProduct, 8)
				));
		
		// 사용자2, 장바구니 추가
		productBasketRepository.save(List.of(
				new ProductBasket("user4", testProduct, 5)
				));
		
		// 사용자1, 결제
		try {
			System.out.println("user3 결재 : " + testProduct.getNumber());
			paymentService.processPayment("user3");
			System.out.println("user3 결재 완료 : " + testProduct.getNumber());
		} catch (SoldOutException e) {
			fail("SoldOutException is not expected");
		} catch (HasKlassException e) {
			fail("HasKlassException is not expected");
		}
		
		assertEquals(2, productRepository.findByProductNumber("91008").getAmount());
		
		// 사용자2, 결제
		try {
			paymentService.processPayment("user4");
		} catch (SoldOutException e) {
			throw e;
		} catch (HasKlassException e) {
			fail("HasKlassException is not expected");
		}
		
		assertEquals(2, productRepository.findByProductNumber("91008").getAmount());
	}

}
