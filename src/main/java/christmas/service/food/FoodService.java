package christmas.service.food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import christmas.domain.food.Food;
import christmas.domain.food.Foods;
import christmas.domain.food.Menu;

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
		String[] separatedInputvalue = inputValue.split(",");

		for (String foodNameAndNumbers : separatedInputvalue) {
			String[] foodNameAndNumber = foodNameAndNumbers.split("-");

			String foodName = foodNameAndNumber[0];
			int number = Integer.parseInt(foodNameAndNumber[1]);
			putFoodExcluingNullValue(foodCounter, foodName, number);
		}

		return foodCounter;
	}

	private void putFoodExcluingNullValue(Map<Food, Integer> foodCounter, String foodName, int number) {
		Optional<Menu> menu = Menu.getMenuByName(foodName);

		if (menu.isPresent()) {
			Food food = menu.get().toFood();
			foodCounter.put(food, number);
		}
	}

	public int calculateFoodsPriceSum(Foods foods) {
		return foods.getFoods().stream().mapToInt(food -> food.price()).sum();
	}
}
