package christmas.service;

public class DDayDiscountService {

	private static final int MIN_DAY = 1;
	private static final int MAX_DAY = 25;
	private static final int D_DAY_DISCOUNT = 100;
	private static final int MAX_DISCOUNT_AMOUNT = 2400;
	private static final int D_DAY_BASIC_DISCOUNT_AMOUNT = 1000;

	public int discount(int day) {
		int discountAmount = D_DAY_BASIC_DISCOUNT_AMOUNT + calculateAdditionalDiscount(day);

		return -discountAmount;
	}

	private int calculateAdditionalDiscount(int day) {
		if (day >= MIN_DAY && day <= MAX_DAY) {
			return ((day - MIN_DAY) * D_DAY_DISCOUNT);
		}

		return MAX_DISCOUNT_AMOUNT;
	}
}