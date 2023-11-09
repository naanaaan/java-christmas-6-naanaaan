package christmas.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.Foods;
import christmas.domain.Menu;

public class FoodCalculatorTest {

	private Foods foods;
	private FoodCalculator foodCalculator;

	@BeforeEach
	void setup() {
		foods = new Foods(List.of(Menu.BBQ_RIBS.toFood(), Menu.CHAMPAGNE.toFood(), Menu.CHRISTMAS_PASTA.toFood()));
		foodCalculator = new FoodCalculator();
	}

	@DisplayName("음식들의 총 가격의 합을 확인한다.")
	@Test
	void checkFoodsPriceSum() {
		int priceSum = foodCalculator.calculateSum(foods);
		int expect = 104_000;

		assertEquals(priceSum, expect);
	}
}
