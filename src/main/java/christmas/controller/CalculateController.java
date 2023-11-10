package christmas.controller;

import christmas.domain.Foods;
import christmas.service.calculation.CalculateSumService;

public class CalculateController {

	private CalculateSumService calculateSumService;

	public CalculateController() {
		this.calculateSumService = new CalculateSumService();
	}

	public int getFoodsPriceSum(Foods foods) {
		return calculateSumService.calculateFoodsPriceSum(foods);
	}
}