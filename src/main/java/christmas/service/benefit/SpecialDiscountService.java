package christmas.service.benefit;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DecemberEvent;
import christmas.domain.visitDate.SpecialDiscountDays;

public class SpecialDiscountService {

	private static final DecemberEvent EVNET = DecemberEvent.SPECIAL_DISCOUNT;
	private static final int DISCOUNT_AMOUNT = 1_000;

	public Benefit getBenefit(int day) {
		int benefitAmount = 0;

		if (SpecialDiscountDays.isContain(day)) {
			benefitAmount = DISCOUNT_AMOUNT;
		}

		return new Benefit(EVNET, benefitAmount);
	}
}