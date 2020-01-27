package net.class101.server1.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.class101.server1.constant.Constant.DefaultValue;
import net.class101.server1.constant.Constant.TypeCode;
import net.class101.server1.entity.Product;
import net.class101.server1.entity.ProductBasket;

public class ProductBasketRepositoryTest {

	private static ProductBasketRepository productBasketRepository = ProductBasketRepository.getInstance();
	
	@Before
	public void initData() {
		productBasketRepository.save(List.of(
				new ProductBasket(DefaultValue.USER_ID, new Product(100, "111222", TypeCode.KLASS, "제목1", 10000, DefaultValue.AMOUNT_INF), 1)
				, new ProductBasket("user2", new Product(100, "111222", TypeCode.KLASS, "제목1", 10000, DefaultValue.AMOUNT_INF), 1)
				));
	}
	
	@After
	public void clearData() {
		productBasketRepository.deleteByUserId(DefaultValue.USER_ID);
		productBasketRepository.deleteByUserId("user2");
	}
	
	@Test
	public void testFindByUserId() {
		List<ProductBasket> findProductBaskets = productBasketRepository.findByUserId(DefaultValue.USER_ID);
		
		assertNotNull(findProductBaskets);
		assertEquals(1, findProductBaskets.size());
	}

	@Test
	public void testSumPriceByUserId() {
		assertEquals(10000, productBasketRepository.sumPriceByUserId(DefaultValue.USER_ID));
	}

	@Test
	public void testSave() {
		productBasketRepository.save(List.of(
				new ProductBasket("user3", new Product(100, "111222", TypeCode.KLASS, "제목1", 10000, DefaultValue.AMOUNT_INF), 1)
				));
		
		List<ProductBasket> findProductBaskets = productBasketRepository.findAll();

		assertNotNull(findProductBaskets);
		assertEquals(3, findProductBaskets.size());
	}

	@Test
	public void testHasDeliveryFee() {
		assertTrue(productBasketRepository.hasDeliveryFee(DefaultValue.USER_ID));
	}

	@Test
	public void testDeleteByUserId() {
		productBasketRepository.deleteByUserId("user3");
		
		List<ProductBasket> findProductBaskets = productBasketRepository.findAll();

		assertNotNull(findProductBaskets);
		assertEquals(2, findProductBaskets.size());
	}

}
