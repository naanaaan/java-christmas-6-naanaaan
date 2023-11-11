package christmas.service.benefit;

import christmas.domain.Benefit;
import christmas.domain.Event;

public class DDayDiscountService {

	private static final Event EVENT = Event.DDAY_DISCOUNT;
	private static final int MIN_DAY = 1;
	private static final int MAX_DAY = 25;
	private static final int D_DAY_DISCOUNT = 100;
	private static final int MAX_DISCOUNT_PRICE = 2_400;
	private static final int D_DAY_BASIC_DISCOUNT_PRICE = 1_000;

	public Benefit getBenefit(int day) {
		int discountPrice = 0;
		discountPrice = D_DAY_BASIC_DISCOUNT_PRICE + calculateAdditionalDiscount(day);

		return new Benefit(EVENT, discountPrice * -1);
	}

	private int calculateAdditionalDiscount(int day) {
		if (day >= MIN_DAY && day <= MAX_DAY) {
			return ((day - MIN_DAY) * D_DAY_DISCOUNT);
		}

		return MAX_DISCOUNT_PRICE;
	}
}