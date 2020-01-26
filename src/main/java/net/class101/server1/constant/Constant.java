package net.class101.server1.constant;

public interface Constant {

	public interface TypeCode {
		public static final String KLASS = "클래스";
		public static final String KIT = "키트";
	}
	
	public interface DefaultValue {
		public static final long AMOUNT_INF = 99999;
		public static final long DELIVERY_FEE = 5000;
	}
	
	public interface UserActionCode {
		public static final String ORDER = "o";
		public static final String QUIT = "q";
		public static final String FINISH_ORDER = " ";
	}
}
