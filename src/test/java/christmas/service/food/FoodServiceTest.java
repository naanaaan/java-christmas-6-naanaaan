package christmas.service.food;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.food.FoodCategory;
import christmas.domain.food.Foods;
import christmas.domain.food.Menu;

public class FoodServiceTest {
	private FoodService foodService;
	private Foods foods;

	@BeforeEach
	void setup() {
		foodService = new FoodService();
		foods = new Foods(List.of(Menu.BBQ_RIBS.toFood(), Menu.CHAMPAGNE.toFood(), Menu.CHRISTMAS_PASTA.toFood()));
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

	@DisplayName("음식들의 총 가격의 합을 확인한다.")
	@Test
	void checkFoodsPriceSum() {
		int priceSum = foodService.calculateFoodsPriceSum(foods);
		int expect = 104_000;

		assertEquals(expect, priceSum);
	}

}