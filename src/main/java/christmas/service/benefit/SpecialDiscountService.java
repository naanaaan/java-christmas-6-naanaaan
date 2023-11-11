package christmas.service.benefit;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.SpecialDiscountDays;

public class SpecialDiscountService {

	private static final Event EVNET = Event.SPECIAL_DISCOUNT;
	private static final int DISCOUNT_AMOUNT = 1_000;

	public Benefit getBenefit(int day) {
		int benefitAmount = 0;

		if (SpecialDiscountDays.isContain(day)) {
			benefitAmount = DISCOUNT_AMOUNT;
		}

		return new Benefit(EVNET, benefitAmount * -1);
	}
}