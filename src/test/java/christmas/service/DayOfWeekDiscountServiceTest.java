package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.Foods;
import christmas.domain.Menu;
import christmas.domain.VisitDate;

class DayOfWeekDiscountServiceTest {

	private DayOfWeekDiscountService dayOfWeekDiscountService;
	private Foods foods;

	@BeforeEach
	void setUp() {
		dayOfWeekDiscountService = new DayOfWeekDiscountService();
		foods = new Foods(List.of(Menu.BBQ_RIBS.toFood(), Menu.T_BONE_STEAK.toFood(), Menu.SEAFOOD_PASTA.toFood(),
				Menu.CHOCO_CAKE.toFood(), Menu.ICE_CREAM.toFood()));
	}

	@DisplayName("주간, 주말에 따른 할인 금액을 확인한다.")
	@CsvSource(value = { "1,-6069", "10,-4046" }, delimiter=',')
	@ParameterizedTest
	void checkDiscountAmount(int day, int expect) {
		int discountAmount = dayOfWeekDiscountService.discount(new VisitDate(day), foods);

		assertEquals(discountAmount, expect);
	}
}
