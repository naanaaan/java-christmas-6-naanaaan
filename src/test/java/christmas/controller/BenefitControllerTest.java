package christmas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.benefit.Benefits;
import christmas.domain.food.Foods;
import christmas.domain.visitDate.VisitDate;

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

	@DisplayName("총 할인, 혜택, 결제금액들을 확인한다1.")
	@Test
	void checkTotalDiscountAmountAndTotalBenefitAmountAndTotalPaymentAmount1() {
		VisitDate visitDate = visitDateController.getVisitDate(3);
		Foods foods = foodController.getFoods("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
		int totalOrderAmount = foodController.getTotalOrderAmount(foods);
		Benefits benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalDiscountAmount = benefits.getTotalDiscountAmount();
		int totalBenefitAmount = benefits.getTotalBenefitAmount();
		int totalPaymentAmount = totalOrderAmount + totalDiscountAmount;

		assertEquals(-6246, totalDiscountAmount);
		assertEquals(-31246, totalBenefitAmount);
		assertEquals(135754, totalPaymentAmount);
	}

	@DisplayName("총 할인, 혜택, 결제금액들을 확인한다2.")
	@Test
	void checkTotalDiscountAmountAndTotalBenefitAmountAndTotalPaymentAmount2() {
		VisitDate visitDate = visitDateController.getVisitDate(26);
		Foods foods = foodController.getFoods("타파스-1,제로콜라-1");
		int totalOrderAmount = foodController.getTotalOrderAmount(foods);
		Benefits benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalDiscountAmount = benefits.getTotalDiscountAmount();
		int totalBenefitAmount = benefits.getTotalBenefitAmount();
		int totalPaymentAmount = totalOrderAmount + totalDiscountAmount;

		assertEquals(0, totalDiscountAmount);
		assertEquals(0, totalBenefitAmount);
		assertEquals(8500, totalPaymentAmount);
	}

	@DisplayName("총 할인, 혜택, 결제금액들을 확인한다3.")
	@Test
	void checkTotalDiscountAmountAndTotalBenefitAmountAndTotalPaymentAmount3() {
		VisitDate visitDate = visitDateController.getVisitDate(30);
		Foods foods = foodController.getFoods("티본스테이크-3,초코케이크-1,제로콜라-1");
		int totalOrderAmount = foodController.getTotalOrderAmount(foods);
		Benefits benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalDiscountAmount = benefits.getTotalDiscountAmount();
		int totalBenefitAmount = benefits.getTotalBenefitAmount();
		int totalPaymentAmount = totalOrderAmount + totalDiscountAmount;

		assertEquals(-6069, totalDiscountAmount);
		assertEquals(-31069, totalBenefitAmount);
		assertEquals(176931, totalPaymentAmount);
	}

	@DisplayName("총 할인, 혜택, 결제금액들을 확인한다4.")
	@Test
	void checkTotalDiscountAmountAndTotalBenefitAmountAndTotalPaymentAmount4() {
		VisitDate visitDate = visitDateController.getVisitDate(3);
		Foods foods = foodController.getFoods("초코케이크-1");
		int totalOrderAmount = foodController.getTotalOrderAmount(foods);
		Benefits benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		int totalDiscountAmount = benefits.getTotalDiscountAmount();
		int totalBenefitAmount = benefits.getTotalBenefitAmount();
		int totalPaymentAmount = totalOrderAmount + totalDiscountAmount;

		assertEquals(-4223, totalDiscountAmount);
		assertEquals(-4223, totalBenefitAmount);
		assertEquals(10777, totalPaymentAmount);
	}
}