package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import christmas.domain.food.Food;
import christmas.domain.food.FoodCategory;
import christmas.domain.food.Foods;
import christmas.domain.food.Menu;
import christmas.util.ErrorMessage;

public class FoodsTest {

	@DisplayName("Foods의 사이즈가 1 ~ 20이 아닐 때 예외가 발생한다.")
	@MethodSource("createCreateFoodByOverSizeMethodParameter")
	@ParameterizedTest
	void createFoodsByOverSize(List<Food> foods) {
		assertThatThrownBy(() -> new Foods(foods))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(String.format(ErrorMessage.ORDER_NUMBER.getMessage(), Foods.MAX_NUMBER));
	}

	static Stream<Arguments> createCreateFoodByOverSizeMethodParameter() {
		List<Food> size0Foods = new ArrayList<>();
		List<Food> size21Foods = generateFoods(Menu.BBQ_RIBS, 21);

		return Stream.of(Arguments.of(size0Foods), Arguments.of(size21Foods));
	}

	@DisplayName("Foods의 사이즈가 1 ~ 20일 때 정상 작동한다.")
	@MethodSource("createCheckNomalOperation1Parameter")
	@ParameterizedTest
	void checkNomalOperation1(List<Food> foods) {
		assertDoesNotThrow(() -> new Foods(foods));
	}

	static Stream<Arguments> createCheckNomalOperation1Parameter() {
		List<Food> size1Foods = new ArrayList<>(List.of(Menu.BBQ_RIBS.toFood()));
		List<Food> size19Foods = generateFoods(Menu.BBQ_RIBS, 19);

		return Stream.of(Arguments.of(size1Foods), Arguments.of(size19Foods));
	}

	@DisplayName("음료수만 존재할 때 예외가 발생한다.")
	@MethodSource("createCreateFoodByOnlyBeverageMethodParameter")
	@ParameterizedTest
	void createFoodsByOnlyBeverage(List<Food> foods) {
		assertThatThrownBy(() -> new Foods(foods))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.ONLY_BEVERAGE.getMessage());
	}

	static Stream<Arguments> createCreateFoodByOnlyBeverageMethodParameter() {
		List<Food> onlyBeverages1 = generateFoods(Menu.ZERO_COLA, 2);
		List<Food> onlyBeverages2 = generateFoods(Menu.RED_WINE, 10);

		return Stream.of(Arguments.of(onlyBeverages1), Arguments.of(onlyBeverages2));
	}
	
	@DisplayName("음료수만 존재하지 않을 때 정상 작동한다.")
	@MethodSource("createCheckNomalOperation2Parameter")
	@ParameterizedTest
	void checkNomalOperation2(List<Food> foods) {
		assertDoesNotThrow(() -> new Foods(foods));
	}

	static Stream<Arguments> createCheckNomalOperation2Parameter() {
		List<Food> foods1 = generateFoods(Menu.BBQ_RIBS, 2);
		List<Food> foods2 = generateFoods(Menu.CAESAR_SALAD, 10);

		return Stream.of(Arguments.of(foods1), Arguments.of(foods2));
	}

	private static List<Food> generateFoods(Menu menu, int limitNumber) {
		return Stream.generate(() -> menu.toFood()).limit(limitNumber).toList();
	}
	
	@DisplayName("특정 카테고리를 가진 음식들의 갯수를 확인한다.")
	@Test
    void checkFoodNumberBySpecificCategory() {
        Foods foods = new Foods(List.of(
                new Food(FoodCategory.APPETIZER, "양송이수프", 6000),
                new Food(FoodCategory.APPETIZER, "양송이수프", 6000),
                new Food(FoodCategory.APPETIZER, "양송이수프", 6000),
                new Food(FoodCategory.MAIN, "티본스테이크", 55000),
                new Food(FoodCategory.BEVERAGE, "레드와인", 60000)
        ));

        assertEquals(3, foods.countFoodsByCategory(FoodCategory.APPETIZER));
        assertEquals(1, foods.countFoodsByCategory(FoodCategory.MAIN));
        assertEquals(1, foods.countFoodsByCategory(FoodCategory.BEVERAGE));
        assertEquals(0, foods.countFoodsByCategory(FoodCategory.DESSERT));
    }

	@DisplayName("음식들을 Map형태로 반환한다.")
	@Test
	void checkFoodToMap() {
		Food food1 = new Food(FoodCategory.MAIN, "티본스테이크", 55_000);
		Food food2 = new Food(FoodCategory.BEVERAGE, "제로콜라", 3_000);
		Food food3 = new Food(FoodCategory.DESSERT, "초코케이크", 15_000);
		Foods foods = new Foods(List.of(food1, food2, food3));
		Map<Food, Integer> foodCounter = foods.toMap();

		assertEquals(foods.getFoodsSize(), foodCounter.size());

		for (Food food : foods.getFoods()) {
			assertTrue(foodCounter.containsKey(food));
			assertEquals(1, foodCounter.get(food));
		}
	}
}
