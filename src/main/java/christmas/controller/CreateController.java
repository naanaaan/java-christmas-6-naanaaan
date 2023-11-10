package christmas.controller;

import christmas.domain.Foods;
import christmas.domain.VisitDate;
import christmas.service.creation.CreateFoodService;
import christmas.service.creation.CreateVisitDateService;

public class CreateController {

	private final CreateFoodService createFoodService;
	private final CreateVisitDateService createVisitDateService;

	public CreateController() {
		this.createFoodService = new CreateFoodService();
		this.createVisitDateService = new CreateVisitDateService();
	}

	public VisitDate getVisitDate(int inputValue) {
		return createVisitDateService.createVisitDate(inputValue);
	}

	public Foods getFoods(String inputValue) {
		return createFoodService.createFoods(inputValue);
	}
}