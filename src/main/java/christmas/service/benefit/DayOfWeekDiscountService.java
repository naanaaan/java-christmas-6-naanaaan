package christmas.service.benefit;

import christmas.domain.FoodCategory;
import christmas.domain.Foods;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.Event;
import christmas.domain.visitDate.VisitDate;

public class DayOfWeekDiscountService {

	private static final Event WEEKEND_EVENT = Event.WEEKEND_DISCOUNT;
	private static final Event WEEKDAY_EVENT = Event.WEEKDAY_DISCOUNT;
	private static final FoodCategory WEEKEND_DISCOUNT_ELIGIBLE = FoodCategory.MAIN;
	private static final FoodCategory WEEKDAY_DISCOUNT_ELIGIBLE = FoodCategory.DESSERT;
	private static final int DISCOUNT_AMOUNT = 2_023;
	
	public Benefit getBenefit(VisitDate visitDate, Foods foods) {
		int foodCount = 0;
		Event event = null;

		if (visitDate.checkWeekend()) {
			foodCount = foods.countFoodsByCategory(WEEKEND_DISCOUNT_ELIGIBLE);
			event = WEEKEND_EVENT;
		}

		if (!visitDate.checkWeekend()) {
			foodCount = foods.countFoodsByCategory(WEEKDAY_DISCOUNT_ELIGIBLE);
			event = WEEKDAY_EVENT;
		}

		return new Benefit(event, foodCount * DISCOUNT_AMOUNT * -1);
	}
}