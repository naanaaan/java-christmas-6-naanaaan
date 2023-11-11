package christmas.domain.food;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import christmas.util.ErrorMessage;

public class Foods {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 20;

	private final List<Food> foods;

	public Foods(List<Food> foods) {
		validate(foods);
		this.foods = foods;
	}

	private void validate(List<Food> foods) {
		validateFoodNumber(foods);
		validateOnlyBeverage(foods);
	}

	private void validateFoodNumber(List<Food> foods) {
		if (isOutOfRange(foods.size())) {
			throw new IllegalArgumentException(
					String.format(ErrorMessage.ORDER_NUMBER.getMessage(), MAX_NUMBER));
		}
	}

	private void validateOnlyBeverage(List<Food> foods) {
		if (foods.stream().allMatch(food -> food.foodCategory() == FoodCategory.BEVERAGE)) {
			throw new IllegalArgumentException(ErrorMessage.ONLY_BEVERAGE.getMessage());
		}
	}

	private boolean isOutOfRange(int size) {
		return size > MAX_NUMBER || size < MIN_NUMBER;
	}

	public int countFoodsByCategory(FoodCategory categoryToCheck) {
		return (int) foods.stream().filter(food -> food.checkCategory(categoryToCheck)).count();
	}

	public Map<Food, Integer> toMap() {
		Map<Food, Integer> foodMap = new HashMap<>();

		for (Food food : foods) {
			foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
		}

		return foodMap;
	}

	public int getFoodsSize() {
		return foods.size();
	}

	public List<Food> getFoods() {
		return Collections.unmodifiableList(foods);
	}
}