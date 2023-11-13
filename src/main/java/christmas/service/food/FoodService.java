package christmas.service.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import christmas.domain.food.Food;
import christmas.domain.food.FoodMenu;
import christmas.domain.food.Foods;
import christmas.view.Input.InputView;

public class FoodService {

	public Foods createFoods(String inputValue) {
		Map<Food, Integer> foodCounter = countFood(inputValue);
		List<Food> foods = new ArrayList<>();

		for (Entry<Food, Integer> foodAndNumber : foodCounter.entrySet()) {
			Food food = foodAndNumber.getKey();
			int number = foodAndNumber.getValue();

			for (int i = 0; i < number; i++) {
				foods.add(food);
			}
		}

		return new Foods(foods);
	}

	private Map<Food, Integer> countFood(String inputValue) {
		Map<Food, Integer> foodCounter = new HashMap<>();

		Arrays.stream(inputValue.split(InputView.ORDER_DELIMITER))
				.map(foodNameAndNumbers -> foodNameAndNumbers.split(InputView.FOOD_NAME_AND_NUMBER_DELIMITER))
				.forEach(foodNameAndNumber -> putFoodExcluingNullValue(foodCounter, foodNameAndNumber[0],
						Integer.parseInt(foodNameAndNumber[1])));

		return foodCounter;
	}

	private void putFoodExcluingNullValue(Map<Food, Integer> foodCounter, String foodName, int number) {
		Optional<FoodMenu> menu = FoodMenu.getMenuByName(foodName);

		if (menu.isPresent()) {
			Food food = menu.get().toFood();
			foodCounter.put(food, number);
		}
	}
}