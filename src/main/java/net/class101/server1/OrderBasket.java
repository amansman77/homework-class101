package net.class101.server1;

import java.util.ArrayList;
import java.util.List;

import net.class101.server1.constant.Constant.TypeCode;

public class OrderBasket {

	private List<OrderProduct> orderProducts = new ArrayList<>();
	private long totalPrice;
	private long kitTotalPrice;

	private OrderBasket(){}
    
    private static class SingleTonHolder{
        private static final OrderBasket instance = new OrderBasket();
    }
     
    public static OrderBasket getInstance(){
        return SingleTonHolder.instance;
    }
    
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void addProduct(Product product, long amount) {
		orderProducts.add(new OrderProduct(product, amount));
		totalPrice += (product.getPrice() * amount);
		if (TypeCode.KIT.equals(product.getType())) {
			kitTotalPrice += (product.getPrice() * amount);
		}
	}
	
	public boolean hasDeliveryFee() {
		if (kitTotalPrice < 50000) {
			return true;
		}
		return false;
	}

	public void clearOrderProducts() {
		orderProducts.clear();
		totalPrice = 0;
		kitTotalPrice = 0;
	}
	
}
