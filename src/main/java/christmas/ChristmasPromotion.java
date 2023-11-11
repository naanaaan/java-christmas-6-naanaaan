package christmas;

import java.util.List;
import java.util.Optional;

import christmas.controller.BadgeController;
import christmas.controller.BenefitController;
import christmas.controller.FoodController;
import christmas.controller.VisitDateController;
import christmas.domain.badge.EventBadge;
import christmas.domain.benefit.Benefit;
import christmas.domain.food.Food;
import christmas.domain.food.Foods;
import christmas.domain.visitDate.VisitDate;
import christmas.view.Input.InputView;
import christmas.view.output.OutputView;

public class ChristmasPromotion {

	private final BenefitController benefitController;
	private final FoodController foodController;
	private final VisitDateController visitDateController;
	private final BadgeController badgeController;
	private final InputView inputView;
	private final OutputView outputView;

	public ChristmasPromotion() {
		this.benefitController = new BenefitController();
		this.foodController = new FoodController();
		this.visitDateController = new VisitDateController();
		this.badgeController = new BadgeController();
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		VisitDate visitDate = getVisitDateProgress();
		Foods foods = getFoodsProgress();
		int totalOrderAmount = foodController.getTotalOrderAmount(foods);
		List<Benefit> benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		Food giveaway = benefitController.getGiveaways(totalOrderAmount);
		int totalDiscountAmount = benefitController.getTotalDiscountAmount(benefits);

		outputView.printEventPreview(visitDate);
		outputView.printOrderMenu(foods.toMap());
		outputView.printTotalOrderAmountBeforeDiscount(totalOrderAmount);
		outputView.printGiveawayMenu(giveaway);
		outputView.printBenefitDetails(benefits);
		printTotalBenefitAmount(totalDiscountAmount, giveaway);
		printTotalPaymentAmount(totalOrderAmount, totalDiscountAmount);
		printEventbadge(totalDiscountAmount, giveaway);
	}

	private void printTotalBenefitAmount(int totalDiscountAmount, Food giveaway) {
		int totalBenefitAmount = benefitController.getTotalBenefitAmount(totalDiscountAmount, giveaway);
		outputView.printTotalBenefitAmount(totalBenefitAmount);
	}

	private void printTotalPaymentAmount(int totalOrderAmount, int totalDiscountAmount) {
		int totalPaymentAmount = benefitController.getTotalPaymentAmount(totalOrderAmount, totalDiscountAmount);
		outputView.printTotalPaymentAmountAfterDiscount(totalPaymentAmount);
	}

	private void printEventbadge(int totalDiscountAmount, Food giveaway) {
		int totalBenefitAmount = benefitController.getTotalBenefitAmount(totalDiscountAmount, giveaway);
		Optional<EventBadge> badge = badgeController.getBadge(totalBenefitAmount);
		outputView.printEventBadge(badge);
	}

	private VisitDate getVisitDateProgress() {
		outputView.printGreeting();
		while (true) {
			try {
				int inputValue = inputView.inputVisitDate();
				VisitDate visitDate = visitDateController.getVisitDate(inputValue);

				return visitDate;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private Foods getFoodsProgress() {
		while (true) {
			try {
				String inputValue = inputView.inputMenus();
				Foods foods = foodController.getFoods(inputValue);
				return foods;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
