package net.class101.server1.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ViewUtilTest {

	@Test
	public void testPriceFormatString() {
		assertEquals("1,000원", ViewUtil.priceFormat("1000"));
	}

	@Test
	public void testPriceFormatLong() {
		assertEquals("1,000원", ViewUtil.priceFormat(1000));
	}

}
