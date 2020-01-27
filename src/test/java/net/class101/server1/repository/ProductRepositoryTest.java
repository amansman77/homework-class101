package net.class101.server1.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import net.class101.server1.entity.Product;

public class ProductRepositoryTest {

	private static ProductRepository productRepository = ProductRepository.getInstance();
	
	@Test
	public void testFindAll() {
		List<Product> products = productRepository.findAll();
		
		assertNotNull(products);
		assertEquals(20, products.size());
	}

	@Test
	public void testFindByProductNumber() {
		Product product = productRepository.findByProductNumber("16374");
		
		assertNotNull(product);
		assertEquals("16374", product.getNumber());
	}

}
