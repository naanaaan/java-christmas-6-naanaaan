package christmas.service.calculation;

import christmas.domain.Foods;

public class CalculateSumService {

	public int calculateFoodsPriceSum(Foods foods){
		return foods.getFoods().stream()
				.mapToInt(food -> food.price())
				.sum();
	}
}