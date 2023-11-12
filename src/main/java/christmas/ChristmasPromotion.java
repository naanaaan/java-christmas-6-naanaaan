package christmas;

import java.util.function.Supplier;

import christmas.controller.BadgeController;
import christmas.controller.BenefitController;
import christmas.controller.FoodController;
import christmas.controller.VisitDateController;
import christmas.domain.badge.Badge;
import christmas.domain.benefit.Benefits;
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
		outputView.printGreeting();
		VisitDate visitDate = getVisitDateProgress();
		Foods foods = getFoodsProgress();
		int totalOrderAmount = foodController.getTotalOrderAmount(foods);
		Benefits benefits = benefitController.getBenefits(visitDate, foods, totalOrderAmount);
		Food giveaway = benefitController.getGiveaways(totalOrderAmount);

		outputView.printEventPreview(visitDate);
		outputView.printOrderMenu(foods.toMap());
		outputView.printTotalOrderAmountBeforeDiscount(totalOrderAmount);
		printBenefitApplicationResult(giveaway, totalOrderAmount, benefits);
	}

	private void printBenefitApplicationResult(Food giveaway, int totalOrderAmount, Benefits benefits) {
		int totalDiscountAmount = benefits.getTotalDiscountAmount();
		int totalBenefitAmount = benefits.getTotalBenefitAmount();
		int totalPaymentAmount = totalOrderAmount + totalDiscountAmount;

		outputView.printGiveawayMenu(giveaway);
		outputView.printBenefitDetails(benefits);
		outputView.printTotalBenefitAmount(totalBenefitAmount);
		outputView.printTotalPaymentAmountAfterDiscount(totalPaymentAmount);
		printEventbadge(totalBenefitAmount);
	}

	private void printEventbadge(int totalBenefitAmount) {
		Badge badge = badgeController.getBadge(totalBenefitAmount);
		outputView.printEventBadge(badge);
	}

	private VisitDate getVisitDateProgress() {
		return convertInputValueToObject(() -> visitDateController.getVisitDate(inputView.inputVisitDate()));
	}

	private Foods getFoodsProgress() {
		return convertInputValueToObject(() -> foodController.getFoods(inputView.inputMenus()));
	}

	private <T> T convertInputValueToObject(Supplier<T> inputSupplier) {
		while (true) {
			try {
				return inputSupplier.get();
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e);
			}
		}
	}
}
