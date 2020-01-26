package net.class101.server1.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.class101.server1.constant.Constant.UserActionCode;
import net.class101.server1.entity.Product;
import net.class101.server1.entity.ProductBasket;
import net.class101.server1.repository.ProductBasketRepository;
import net.class101.server1.repository.ProductRepository;

public class OrderView {
	
	private ProductRepository productRepository = ProductRepository.getInstance();
	private ProductBasketRepository productBasketRepository = ProductBasketRepository.getInstance();
	
	public void showOrder(Scanner scanner) {
		List<ProductBasket> tempOrderProducts = new ArrayList<>();
		
		while (true) {
    		System.out.print("상품번호 : ");
        	String selectProductNumber = scanner.next();
    		if (UserActionCode.FINISH_ORDER.equals(selectProductNumber)) {
    			break;
    		}
    		
    		System.out.print("수량 : ");
        	long selectAmount = scanner.nextLong();
        	
        	Product product = productRepository.findByProductNumber(selectProductNumber);
        	tempOrderProducts.add(new ProductBasket(product, selectAmount));
		}
		productBasketRepository.save(tempOrderProducts);
	}

}
