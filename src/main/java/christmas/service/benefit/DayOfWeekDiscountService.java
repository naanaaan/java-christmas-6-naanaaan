package christmas.service.benefit;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DecemberEvent;
import christmas.domain.food.FoodCategory;
import christmas.domain.food.Foods;
import christmas.domain.visitDate.VisitDate;

public class DayOfWeekDiscountService {

	private static final DecemberEvent WEEKEND_EVENT = DecemberEvent.WEEKEND_DISCOUNT;
	private static final DecemberEvent WEEKDAY_EVENT = DecemberEvent.WEEKDAY_DISCOUNT;
	private static final FoodCategory WEEKEND_DISCOUNT_ELIGIBLE = FoodCategory.MAIN;
	private static final FoodCategory WEEKDAY_DISCOUNT_ELIGIBLE = FoodCategory.DESSERT;
	private static final int DISCOUNT_AMOUNT = 2_023;

	public Benefit createBenefit(VisitDate visitDate, Foods foods) {
		int foodCount = 0;
		DecemberEvent event = null;

		if (visitDate.isWeekend()) {
			foodCount = foods.countFoodsByCategory(WEEKEND_DISCOUNT_ELIGIBLE);
			event = WEEKEND_EVENT;
		}

		if (!visitDate.isWeekend()) {
			foodCount = foods.countFoodsByCategory(WEEKDAY_DISCOUNT_ELIGIBLE);
			event = WEEKDAY_EVENT;
		}

		return new Benefit(event, foodCount * DISCOUNT_AMOUNT);
	}
}