package christmas.service.benefit;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.SpecialDiscountDays;

public class SpecialDiscountService {

	private static final Event EVNET = Event.SPECIAL_DISCOUNT;
	private static final int DISCOUNT_PRICE = 1_000;

	public Benefit getBenefit(int day) {
		int discountPrice = 0;

		if (SpecialDiscountDays.isContain(day)) {
			discountPrice = DISCOUNT_PRICE;
		}

		return new Benefit(EVNET, discountPrice * -1);
	}
}