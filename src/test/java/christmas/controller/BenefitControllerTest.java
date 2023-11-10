package christmas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.Benefit;
import christmas.domain.Foods;
import christmas.domain.VisitDate;

public class BenefitControllerTest {

	private BenefitController benefitController;
	private VisitDateController visitDateController;
	private FoodController foodController;

	@BeforeEach
	void setUp() {
		benefitController = new BenefitController();
		visitDateController = new VisitDateController();
		foodController = new FoodController();
	}

	@DisplayName("총 혜택 금액을 확인한다1.")
	@Test
	void checktotalBenefitsAmount1() {
		VisitDate visitDate = visitDateController.getVisitDate(3);
		Foods foods = foodController.getFoods("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
		int totalOrderAmount = foodController.getFoodsPriceSum(foods);
		List<Benefit> benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalBenefitsAmount = benefitController.getBenefitDiscountAmountSum(benefits);

		assertEquals(totalBenefitsAmount, -31246);
	}

	@DisplayName("총 혜택 금액을 확인한다2.")
	@Test
	void checktotalBenefitsAmount2() {
		VisitDate visitDate = visitDateController.getVisitDate(26);
		Foods foods = foodController.getFoods("타파스-1,제로콜라-1");
		int totalOrderAmount = foodController.getFoodsPriceSum(foods);
		List<Benefit> benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalBenefitsAmount = benefitController.getBenefitDiscountAmountSum(benefits);

		assertEquals(totalBenefitsAmount, 0);
	}

	@DisplayName("총 혜택 금액을 확인한다3.")
	@Test
	void checktotalBenefitsAmount3() {
		VisitDate visitDate = visitDateController.getVisitDate(30);
		Foods foods = foodController.getFoods("티본스테이크-3,초코케이크-1,제로콜라-1");
		int totalOrderAmount = foodController.getFoodsPriceSum(foods);
		List<Benefit> benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalBenefitsAmount = benefitController.getBenefitDiscountAmountSum(benefits);

		assertEquals(totalBenefitsAmount, -34469);
	}

	@DisplayName("총 혜택 금액을 확인한다4.")
	@Test
	void checktotalBenefitsAmount4() {
		VisitDate visitDate = visitDateController.getVisitDate(3);
		Foods foods = foodController.getFoods("초코케이크-1");
		int totalOrderAmount = foodController.getFoodsPriceSum(foods);
		List<Benefit> benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalBenefitsAmount = benefitController.getBenefitDiscountAmountSum(benefits);

		assertEquals(totalBenefitsAmount, -4223);
	}
}
