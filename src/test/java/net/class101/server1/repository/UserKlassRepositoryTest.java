package net.class101.server1.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.class101.server1.constant.Constant.DefaultValue;
import net.class101.server1.constant.Constant.TypeCode;
import net.class101.server1.entity.Product;
import net.class101.server1.entity.UserKlass;

public class UserKlassRepositoryTest {

	private static UserKlassRepository userKlassRepository = UserKlassRepository.getInstance();
	
	@Before
	public void initData() {
		userKlassRepository.save(List.of(
				new UserKlass(new Product(100, "111222", TypeCode.KLASS, "제목1", 10000, DefaultValue.AMOUNT_INF))
				, new UserKlass(new Product(101, "111222", TypeCode.KLASS, "제목1", 10000, DefaultValue.AMOUNT_INF))
				));
	}
	
	@After
	public void clearData() {
		userKlassRepository.deleteAll();
	}
	
	@Test
	public void testFindAll() {
		List<UserKlass> userKlasses = userKlassRepository.findAll();
		
		assertNotNull(userKlasses);
		assertEquals(2, userKlasses.size());
	}

	@Test
	public void testFindBySn() {
		List<UserKlass> userKlasses = userKlassRepository.findBySn(new HashSet<>(List.of(100l)));
		
		assertNotNull(userKlasses);
		assertEquals(1, userKlasses.size());
	}

}
