package christmas.domain;

import java.util.Collections;
import java.util.List;

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
			throw new IllegalArgumentException();
		}
	}

	private void validateOnlyBeverage(List<Food> foods) {
		if (foods.stream().allMatch(food -> food.foodCategory() == FoodCategory.BEVERAGE)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isOutOfRange(int size) {
		return size > MAX_NUMBER || size < MIN_NUMBER;
	}
	
	public int getFoodsSize() {
		return foods.size();
	}
	
	public List<Food> getFoods() {
		return Collections.unmodifiableList(foods);
	}
}