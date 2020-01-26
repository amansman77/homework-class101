package net.class101.server1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.class101.server1.constant.Constant.TypeCode;
import net.class101.server1.entity.ProductBasket;
import net.class101.server1.entity.UserKlass;
import net.class101.server1.exception.HasKlassException;
import net.class101.server1.exception.SoldOutException;
import net.class101.server1.repository.ProductBasketRepository;
import net.class101.server1.repository.UserKlassRepository;

public class PaymentService {

	private ProductBasketRepository productBasketRepository = ProductBasketRepository.getInstance();
	private UserKlassRepository userKlassRepository = UserKlassRepository.getInstance();
	
	private PaymentService(){}
    
    private static class SingleTonHolder{
        private static final PaymentService instance = new PaymentService();
    }
     
    public static PaymentService getInstance(){
        return SingleTonHolder.instance;
    }
    
	public long getTotalPrice() {
		return productBasketRepository.sumAllPrice()
				+ (productBasketRepository.hasDeliveryFee()?5000:0);
	}

	synchronized public void processPayment() throws SoldOutException, HasKlassException {
		List<ProductBasket> findProductBaskets = productBasketRepository.findAll();
		
		Set<Long> klassProductsSn = findProductBaskets.stream()
			.filter(p -> TypeCode.KLASS.equals(p.getProduct().getType()))
			.map(p -> p.getProduct().getSn())
			.collect(Collectors.toSet());
		
		List<UserKlass> findUserKlass = userKlassRepository.findBySn(klassProductsSn);
		if (findUserKlass.size() > 0) {
			throw new HasKlassException();
		}
		
		for (ProductBasket productBasket : findProductBaskets) {
			if (productBasket.getAmount() > productBasket.getProduct().getAmount()) {
				throw new SoldOutException();
			}
		}
		
		for (ProductBasket productBasket : findProductBaskets) {
			if (TypeCode.KIT.equals(productBasket.getProduct().getType())) {
				productBasket.getProduct().setAmount(
						productBasket.getProduct().getAmount() - productBasket.getAmount()
						);
			} else if (TypeCode.KLASS.equals(productBasket.getProduct().getType())) {
				userKlassRepository.save(new UserKlass(productBasket.getProduct()));
			}
		}
		
		productBasketRepository.deleteAll();
	}
	
}
