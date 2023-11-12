package christmas.service.benefit;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DecemberEvent;

public class DDayDiscountService {

	private static final DecemberEvent EVENT = DecemberEvent.DDAY_DISCOUNT;
	private static final int MIN_DAY = 1;
	private static final int MAX_DAY = 25;
	private static final int D_DAY_DISCOUNT = 100;
	private static final int D_DAY_BASIC_DISCOUNT_AMOUNT = 1_000;

	public Benefit getBenefit(int day) {
		int benefitAmount = calculateAdditionalDiscount(day);

		return new Benefit(EVENT, benefitAmount);
	}

	private int calculateAdditionalDiscount(int day) {
		if (day >= MIN_DAY && day <= MAX_DAY) {
			return D_DAY_BASIC_DISCOUNT_AMOUNT + ((day - MIN_DAY) * D_DAY_DISCOUNT);
		}

		return 0;
	}
}