package christmas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.Foods;
import christmas.domain.VisitDate;

public class BenefitControllerTest {

	private BenefitController benefitController;
	private CreateController createController;
	private CalculateController calculateController;

	@BeforeEach
	void setUp() {
		benefitController = new BenefitController();
		createController = new CreateController();
		calculateController = new CalculateController();
	}

	@DisplayName("총 혜택 금액을 확인한다1.")
	@Test
	void checktotalBenefitsAmount1() {
		VisitDate visitDate = createController.getVisitDate(3);
		Foods foods = createController.getFoods("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
		int totalOrderAmount = calculateController.getFoodsPriceSum(foods);
		int totalBenefitsAmount = benefitController.getTotalBenefitsAmount(visitDate, foods, totalOrderAmount);

		assertEquals(totalBenefitsAmount, 31246);
	}

	@DisplayName("총 혜택 금액을 확인한다2.")
	@Test
	void checktotalBenefitsAmount2() {
		VisitDate visitDate = createController.getVisitDate(26);
		Foods foods = createController.getFoods("타파스-1,제로콜라-1");
		int totalOrderAmount = calculateController.getFoodsPriceSum(foods);
		int totalBenefitsAmount = benefitController.getTotalBenefitsAmount(visitDate, foods, totalOrderAmount);

		assertEquals(totalBenefitsAmount, 0);
	}

	@DisplayName("총 혜택 금액을 확인한다3.")
	@Test
	void checktotalBenefitsAmount3() {
		VisitDate visitDate = createController.getVisitDate(30);
		Foods foods = createController.getFoods("티본스테이크-3,초코케이크-1,제로콜라-1");
		int totalOrderAmount = calculateController.getFoodsPriceSum(foods);
		int totalBenefitsAmount = benefitController.getTotalBenefitsAmount(visitDate, foods, totalOrderAmount);

		assertEquals(totalBenefitsAmount, 34469);
	}
}
