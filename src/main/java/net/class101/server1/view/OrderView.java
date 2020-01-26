package net.class101.server1.view;

import java.util.Scanner;

import net.class101.server1.OrderBasket;
import net.class101.server1.Product;
import net.class101.server1.ProductManager;
import net.class101.server1.constant.Constant.UserActionCode;

public class OrderView {
	
	private static ProductManager productManager = new ProductManager();
	
	public void showOrder(Scanner scanner) {
		while (true) {
    		System.out.print("상품번호 : ");
        	String selectProductNumber = scanner.next();
    		if (UserActionCode.FINISH_ORDER.equals(selectProductNumber)) {
    			break;
    		}
    		
    		System.out.print("수량 : ");
        	long selectAmount = scanner.nextLong();
        	
        	Product product = productManager.findByProductNumber(selectProductNumber);
        	OrderBasket.getInstance().addProduct(product, selectAmount);
		}
	}

}
