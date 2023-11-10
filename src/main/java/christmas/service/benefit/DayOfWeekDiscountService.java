package christmas.service.benefit;

import christmas.domain.FoodCategory;
import christmas.domain.Foods;
import christmas.domain.VisitDate;

public class DayOfWeekDiscountService {

	private static final FoodCategory WEEKEND_DISCOUNT_ELIGIBLE = FoodCategory.MAIN;
	private static final FoodCategory WEEKDAY_DISCOUNT_ELIGIBLE = FoodCategory.DESSERT;
	private static final int DISCOUNT_AMOUNT = 2_023;

	public int discount(VisitDate visitDate, Foods foods) {
		int foodCount = 0;

		if (visitDate.checkWeekend()) {
			foodCount = foods.countFoodsByCategory(WEEKEND_DISCOUNT_ELIGIBLE);
		}
		
		if (!visitDate.checkWeekend()) {
			foodCount = foods.countFoodsByCategory(WEEKDAY_DISCOUNT_ELIGIBLE);
		}

		return -(foodCount * DISCOUNT_AMOUNT);
	}
}