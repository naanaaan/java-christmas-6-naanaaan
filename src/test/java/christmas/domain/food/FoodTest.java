package christmas.domain.food;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoodTest {

	@DisplayName("음식의 카테고리를 확인한다..")
	@Test
	void checkFoodCategory() {
		Food food = new Food(FoodCategory.APPETIZER, "에피타이저", 2000);

		assertTrue(food.checkCategory(FoodCategory.APPETIZER));
		assertFalse(food.checkCategory(FoodCategory.MAIN));
	}
}