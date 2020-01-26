package net.class101.server1.view;

import java.util.List;

import net.class101.server1.constant.Constant.DefaultValue;
import net.class101.server1.constant.Constant.UserActionCode;
import net.class101.server1.entity.Product;
import net.class101.server1.entity.ProductBasket;
import net.class101.server1.repository.ProductBasketRepository;
import net.class101.server1.repository.ProductRepository;
import net.class101.server1.service.PaymentService;
import net.class101.server1.util.ViewUtil;

public class MainView {

	private PaymentService paymentService = PaymentService.getInstance();
	private ProductRepository productRepository = ProductRepository.getInstance();
	private ProductBasketRepository productBasketRepository = ProductBasketRepository.getInstance();
	
	public void showOrderOrQuit() {
		System.out.print("입력(" + UserActionCode.ORDER + "[order]: 주문, " + UserActionCode.QUIT + "[quit]: 종료) : ");
	}

	public void showProducts() {
		System.out.println("상품 번호			상품명				판매가격	재고수");
		for (Product product : productRepository.findAll()) {
			System.out.println(product.getNumber() + "	" + product.getTitle() + "	" + product.getPrice() + "	" + product.getAmount());
		}
		
	}

	public void showBasket() {
		System.out.println("주문내역:");
		System.out.println("-----------------------------------------------");
		List<ProductBasket> productsInBasket = productBasketRepository.findAll();
		for (int i = productsInBasket.size()-1; i >= 0; i--) {
			ProductBasket productBasket = productsInBasket.get(i);
			System.out.println(productBasket.getProduct().getTitle() + " - " + productBasket.getAmount() + "개");
		}
		System.out.println("-----------------------------------------------");
		System.out.println("주문금액: " + ViewUtil.priceFormat(productBasketRepository.sumAllPrice()));
		if (productBasketRepository.hasDeliveryFee()) {
			System.out.println("베송비: " + ViewUtil.priceFormat(DefaultValue.DELIVERY_FEE));
		}
		System.out.println("-----------------------------------------------");
	}

	public void showPayment() {
		paymentService.processPayment();
		
		System.out.println("지불금액: " + ViewUtil.priceFormat(paymentService.getTotalPrice()));
		System.out.println("-----------------------------------------------");
	}

}
