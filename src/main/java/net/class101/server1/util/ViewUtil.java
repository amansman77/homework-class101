package net.class101.server1.util;

import java.text.NumberFormat;

public class ViewUtil {

	public static String priceFormat(String price) {
		return ViewUtil.priceFormat(Long.valueOf(price));
	}

	public static String priceFormat(long price) {
		NumberFormat formatter = NumberFormat.getInstance();
		return formatter.format(price) + "원";
	}
	
}
