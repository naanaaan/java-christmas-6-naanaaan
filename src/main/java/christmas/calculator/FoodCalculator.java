package christmas.calculator;

import christmas.domain.Foods;

public final class FoodCalculator implements Calculator<Integer, Foods> {

	@Override
	public Integer calculateSum(final Foods foods){
		return foods.getFoods().stream()
				.mapToInt(food -> food.price())
				.sum();
	}
}