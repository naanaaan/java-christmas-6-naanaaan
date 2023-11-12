package christmas.controller;

import christmas.domain.food.Foods;
import christmas.service.food.FoodService;

public class FoodController {

	private final FoodService foodService;

	public FoodController() {
		this.foodService = new FoodService();
	}

	public Foods getFoods(String inputValue) {
		return foodService.createFoods(inputValue);
	}

	public int getTotalOrderAmount(Foods foods) {
		return foods.getPriceSum();
	}
}
