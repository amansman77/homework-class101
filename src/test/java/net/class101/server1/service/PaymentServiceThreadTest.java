package net.class101.server1.service;

import org.junit.Test;

public class PaymentServiceThreadTest {

	@Test
	public void testAsyncSoldOut() {
		User1Thread user1Thread = new User1Thread();
		Thread thread1 = new Thread(user1Thread, "첫번째 사용자");

		thread1.start();
		
		User2Thread user2Thread = new User2Thread();
		Thread thread2 = new Thread(user2Thread, "두번째 사용자");

		thread2.start();
	}
	
}
