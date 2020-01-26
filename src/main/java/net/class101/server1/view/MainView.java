package net.class101.server1.view;

import java.util.List;

import net.class101.server1.OrderBasket;
import net.class101.server1.OrderProduct;
import net.class101.server1.PaymentManager;
import net.class101.server1.Product;
import net.class101.server1.ProductManager;
import net.class101.server1.constant.Constant.DefaultValue;
import net.class101.server1.constant.Constant.UserActionCode;
import net.class101.server1.util.ViewUtil;

public class MainView {

	private ProductManager productManager = new ProductManager();
	private PaymentManager paymentManager = new PaymentManager();
	
	public void showOrderOrQuit() {
		System.out.print("입력(" + UserActionCode.ORDER + "[order]: 주문, " + UserActionCode.QUIT + "[quit]: 종료) : ");
	}

	public void showProducts() {
		System.out.println("상품 번호			상품명				판매가격	재고수");
		for (Product product : productManager.getProducts()) {
			System.out.println(product.getNumber() + "	" + product.getTitle() + "	" + product.getPrice() + "	" + product.getAmount());
		}
		
	}

	public void showBasket() {
		System.out.println("주문내역:");
		System.out.println("-----------------------------------------------");
		List<OrderProduct> productsInBasket = OrderBasket.getInstance().getOrderProducts();
		for (int i = productsInBasket.size()-1; i >= 0; i--) {
			OrderProduct orderProduct = productsInBasket.get(i);
			System.out.println(orderProduct.getProduct().getTitle() + " - " + orderProduct.getAmount() + "개");
		}
		System.out.println("-----------------------------------------------");
		System.out.println("주문금액: " + ViewUtil.priceFormat(OrderBasket.getInstance().getTotalPrice()));
		if (OrderBasket.getInstance().hasDeliveryFee()) {
			System.out.println("베송비: " + ViewUtil.priceFormat(DefaultValue.DELIVERY_FEE));
		}
		System.out.println("-----------------------------------------------");
	}

	public void showPayment() {
		System.out.println("지불금액: " + ViewUtil.priceFormat(paymentManager.getTotalPrice()));
		System.out.println("-----------------------------------------------");
		
		OrderBasket.getInstance().clearOrderProducts();
	}

}
