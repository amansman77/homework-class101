package net.class101.server1;

public class PaymentManager {

	public long getTotalPrice() {
		/*
		 * TODO : 결제 구현
		 */
		return OrderBasket.getInstance().getTotalPrice()
				+ (OrderBasket.getInstance().hasDeliveryFee()?5000:0);
	}
	
}
