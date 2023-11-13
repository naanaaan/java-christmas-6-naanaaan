package christmas.domain.food;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FoodTest {

	@DisplayName("음식의 카테고리를 확인한다.")
	@CsvSource(value = { "APPETIZER,APPETIZER,true", "MAIN,APPETIZER,false", "DESSERT,BEVERAGE,false",
			"BEVERAGE,BEVERAGE,true" }, delimiter = ',')
	@ParameterizedTest
	void checkFoodCategory(FoodCategory category, FoodCategory categoryToCheck, boolean expect) {
		Food food = new Food(category, "음식이름", 2000);

		assertEquals(expect, food.isCategoryMatching(categoryToCheck));
	}
}