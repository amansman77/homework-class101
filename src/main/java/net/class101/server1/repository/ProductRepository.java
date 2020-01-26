package net.class101.server1.repository;

import java.util.List;
import java.util.stream.Collectors;

import net.class101.server1.constant.Constant.DefaultValue;
import net.class101.server1.constant.Constant.TypeCode;
import net.class101.server1.entity.Product;

public class ProductRepository {

	private List<Product> products = List.of(
			new Product(1, "16374", TypeCode.KLASS, "스마트스토어로 월 100만원 만들기, 평범한 사람이 돈을 만드는 비법", 151950, DefaultValue.AMOUNT_INF)
			, new Product(2, "26825", TypeCode.KLASS, "해금, 특별하고 아름다운 나만의 반려악기", 114500, DefaultValue.AMOUNT_INF)
			, new Product(3, "65625", TypeCode.KLASS, "일상에 따뜻한 숨결을 불어넣어요, 반지수와 함께하는 아이패트 드로잉", 174500, DefaultValue.AMOUNT_INF)
			, new Product(4, "91008", TypeCode.KIT, "작고 쉽게 그려요 - 부담없이 시작하는 수채화 미니 키트", 28000, 10)
			, new Product(5, "9236", TypeCode.KIT, "하루의 시작과 끝, 욕실의 포근함을 선사하는 천연 비누", 9900, 22)
			, new Product(6, "55527", TypeCode.KLASS, "코바늘로 인형을 만들자! 시은맘의 꼼지락 작업실", 299500, DefaultValue.AMOUNT_INF)
			, new Product(7, "2344", TypeCode.KLASS, "일상 유튜버 슛뚜의 감성을 그대로. 영화같은 브이로그 제작법", 184500, DefaultValue.AMOUNT_INF)
			, new Product(8, "60538", TypeCode.KIT, "시작에 대한 부담을 덜다. 가격 절약 아이패드 특가전", 135800, 7)
			, new Product(9, "78156", TypeCode.KIT, "일상을 따뜻하게 채우는 썬캐쳐와 무드등", 45000, 16)
			, new Product(10, "53144", TypeCode.KLASS, "여행 드로잉, 꿈만 꾸지 마세요. 핀든아트와 여행, 그리다", 249500, DefaultValue.AMOUNT_INF)
			, new Product(11, "78311", TypeCode.KLASS, "사각사각 손글씨의 낭만, 펜크래프트의 한글 정자체 펜글씨", 209500, DefaultValue.AMOUNT_INF)
			, new Product(12, "97166", TypeCode.KIT, "이렇게 멋진 수채화 키트, 어때요? 클래스101과 고넹이화방이 기획한 3가지 수채화 키트", 96900, 5)
			, new Product(13, "83791", TypeCode.KLASS, "월급으로 만족하지 못하는 분들을 위한 아마존/이베이 입문", 178500, DefaultValue.AMOUNT_INF)
			, new Product(14, "58395", TypeCode.KIT, "선과 여백으로 채우는 2020년 캘린더와 엽서", 18620, 31)
			, new Product(15, "39712", TypeCode.KIT, "집에서 느끼는 겨울의 묵직한 포근함, 플랜테리어 아이템", 17600, 8)
			, new Product(16, "96558", TypeCode.KLASS, "사진 입문자를 위한 쉽게 배우고 빨리 써먹는 사진과 라이트룸", 234500, DefaultValue.AMOUNT_INF)
			, new Product(17, "42031", TypeCode.KIT, "나만의 음악을 만들기 위한 장비 패키지", 209000, 2)
			, new Product(18, "45947", TypeCode.KLASS, "일러스트레이터 집시의 매력적인 얼굴 그리기", 249500, DefaultValue.AMOUNT_INF)
			, new Product(19, "74218", TypeCode.KLASS, "나만의 문방구를 차려요! 그리지영의 타블렛으로 굿즈 만들기", 191600, DefaultValue.AMOUNT_INF)
			, new Product(20, "28448", TypeCode.KLASS, "당신도 할 수 있다! 베테랑 실무자가 알려주는 모션그래픽의 모든 것", 152200, DefaultValue.AMOUNT_INF)
			);

	private ProductRepository(){}
	
	private static class SingleTonHolder{
        private static final ProductRepository instance = new ProductRepository();
    }
     
    public static ProductRepository getInstance(){
        return SingleTonHolder.instance;
    }
    
	public List<Product> findAll() {
		return products;
	}

	public Product findByProductNumber(String selectProductNumber) {
		List<Product> findProducts = products.stream().filter(f -> f.getNumber().equals(selectProductNumber)).collect(Collectors.toList());
		if (findProducts.size() > 0) {
			return findProducts.get(0);
		} else {
			return new Product();
		}
	}
	
}
