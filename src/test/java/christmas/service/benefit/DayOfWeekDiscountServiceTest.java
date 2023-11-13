package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.food.Foods;
import christmas.domain.food.FoodMenu;
import christmas.domain.visitDate.VisitDate;

class DayOfWeekDiscountServiceTest {

	private DayOfWeekDiscountService dayOfWeekDiscountService;
	private Foods foods;

	@BeforeEach
	void setUp() {
		dayOfWeekDiscountService = new DayOfWeekDiscountService();
		foods = new Foods(List.of(FoodMenu.BBQ_RIBS.toFood(), FoodMenu.T_BONE_STEAK.toFood(),
				FoodMenu.SEAFOOD_PASTA.toFood(), FoodMenu.CHOCO_CAKE.toFood(), FoodMenu.ICE_CREAM.toFood()));
	}

	@DisplayName("주간, 주말에 따른 할인 금액을 확인한다.")
	@CsvSource(value = { "1,6069", "10,4046" }, delimiter = ',')
	@ParameterizedTest
	void checkDiscountAmount(int day, int expect) {
		int discountAmount = dayOfWeekDiscountService.createBenefit(new VisitDate(day), foods).benefitAmount();

		assertEquals(expect, discountAmount);
	}
}