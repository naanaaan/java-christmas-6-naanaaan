package christmas.service.food;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import christmas.domain.Foods;
import christmas.domain.Menu;

public class FoodServiceTest {
	private FoodService foodService;
	private Foods foods;

	@BeforeEach
	void setup() {
		foodService = new FoodService();
		foods = new Foods(List.of(Menu.BBQ_RIBS.toFood(), Menu.CHAMPAGNE.toFood(), Menu.CHRISTMAS_PASTA.toFood()));
	}

	@DisplayName("음식들의 총 가격의 합을 확인한다.")
	@Test
	void checkFoodsPriceSum() {
		int priceSum = foodService.calculateFoodsPriceSum(foods);
		int expect = 104_000;

		assertEquals(priceSum, expect);
	}

	@DisplayName("음식들을 생성하고 사이즈를 확인한다.")
	@CsvSource(value = { "타파스-1,제로콜라-1;2", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1;5" }, delimiter = ';')
	@ParameterizedTest
	void testCreateFoodsForCheckFoodsSize(String foodsAndNumbers, int expect) {
		assertDoesNotThrow(() -> {
			Foods foods = foodService.createFoods(foodsAndNumbers);
			assertEquals(foods.getFoodsSize(), expect);
		});
	}

	@DisplayName("음식이름을 중복되게 입력할 시 예외가 발생한다.")
	@ValueSource(strings = { "시저샐러드-1,시저샐러드-1", "타파스-1,타파스-2,제로콜라-1" })
	@ParameterizedTest
	void testCreateFoodsForCheckDuplicateFoodNameException(String foodsAndNumbers) {
		assertThatThrownBy(() -> foodService.createFoods(foodsAndNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
