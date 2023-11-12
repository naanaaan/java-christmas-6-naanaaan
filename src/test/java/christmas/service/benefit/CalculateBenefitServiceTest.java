package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.food.Food;
import christmas.domain.food.FoodMenu;

class CalculateBenefitServiceTest {

	private CalculateBenefitService calculateBenefitService;

	@BeforeEach
	void setUp() {
		calculateBenefitService = new CalculateBenefitService();
	}

	@DisplayName("총혜택 금액을 확인한다.")
	@CsvSource(value = { "130000,-4423,-29423", "120000,0,-25000", "100000,-2000,-2000" }, delimiter = ',')
	@ParameterizedTest
	void checkTotalBenefitAmount(int totalOrderAmount, int totalDiscountAmount, int expect) {
		Food giveaway = null;

		if (totalOrderAmount >= 120000) {
			giveaway = FoodMenu.CHAMPAGNE.toFood();
		}

		int actualTotalBenefitAmount = calculateBenefitService
				.calculateTotalBenefitAmount(totalDiscountAmount, giveaway);

		assertEquals(expect, actualTotalBenefitAmount);
	}

	@DisplayName("총결제 금액 확인한다.")
	@CsvSource(value = { "50000,-8000,42000", "50000,-5000,45000", "50000,0,50000" }, delimiter = ',')
	@ParameterizedTest
	void checkTotalPaymentAmount(int totalOrderAmount, int totalDiscountAmount, int expect) {

		int totalPaymentAmount = calculateBenefitService
				.cacluclateTotalPaymentAmount(totalOrderAmount, totalDiscountAmount);

		assertEquals(expect, totalPaymentAmount);
	}
}