package christmas.service.food;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.food.FoodCategory;
import christmas.domain.food.Foods;

public class FoodServiceTest {
	private FoodService foodService;

	@BeforeEach
	void setup() {
		foodService = new FoodService();
	}

	@DisplayName("입력값에 따라 생성되는 음식들을 확인한다.")
	@Test
	void checkCreateFoodsByInputValue() {
		String inputValue = "바비큐립-1,샴페인-1,크리스마스파스타-1";
		Foods foods = foodService.createFoods(inputValue);

		assertEquals(2, foods.countFoodsByCategory(FoodCategory.MAIN));
		assertEquals(1, foods.countFoodsByCategory(FoodCategory.BEVERAGE));
		assertEquals(0, foods.countFoodsByCategory(FoodCategory.APPETIZER));
	}
}