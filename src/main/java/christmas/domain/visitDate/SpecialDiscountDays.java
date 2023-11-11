package christmas.domain.visitDate;

import java.util.Arrays;
import java.util.List;

public class SpecialDiscountDays {

	private static final List<Integer> DISCOUNT_DAYS = Arrays.asList(3, 10, 17, 24, 25, 31);

	private SpecialDiscountDays() {
		throw new AssertionError();
	}

	public static boolean isContain(int day) {
		return DISCOUNT_DAYS.contains(day);
	}
}