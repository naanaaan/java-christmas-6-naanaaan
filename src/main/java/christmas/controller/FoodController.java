package christmas.controller;

import christmas.domain.Foods;
import christmas.service.food.FoodService;

public class FoodController {

	private final FoodService foodService;

	public FoodController() {
		this.foodService = new FoodService();
	}

	public Foods getFoods(String inputValue) {
		return foodService.createFoods(inputValue);
	}

	public int getFoodsPriceSum(Foods foods) {
		return foodService.calculateFoodsPriceSum(foods);
	}
}
