package christmas.service.benefit;

import christmas.domain.SpecialDiscountDays;

public class SpecialDiscountService {

	private static final int DISCOUNT_AMOUNT = 1_000;

	public int discount(int day) {
		int discountAmount = 0;

		if (SpecialDiscountDays.isContain(day)) {
			discountAmount = DISCOUNT_AMOUNT;
		}

		return discountAmount;
	}
}