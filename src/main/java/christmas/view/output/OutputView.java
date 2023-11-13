package christmas.view.output;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import christmas.domain.badge.Badge;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.Benefits;
import christmas.domain.food.Food;
import christmas.domain.visitDate.VisitDate;

public class OutputView {

	private static final String NEW_LINE = System.lineSeparator();

	public void printGreeting() {
		System.out.println(OutputViewMessage.GREETING.getMessage());
	}

	public void printEventPreview(VisitDate visitDate) {
		int day = visitDate.getDay();
		String message = String.format(OutputViewMessage.EVENT_PREVIEW.getMessage(), day);

		System.out.println(message);
	}

	public void printOrderMenu(Map<Food, Integer> foods) {
		StringJoiner orderMenuMessage = new StringJoiner(System.lineSeparator());
		orderMenuMessage.add(OutputViewMessage.ORDER_MENU.getMessage());

		for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
			String foodName = entry.getKey().getName();
			int number = entry.getValue();

			orderMenuMessage.add(String.format("%s %d개", foodName, number));
		}

		System.out.println(NEW_LINE + orderMenuMessage.toString());
	}

	public void printTotalOrderAmountBeforeDiscount(int totalOrderAmount) {
		StringJoiner beforeDiscountMessage = new StringJoiner(NEW_LINE);
		beforeDiscountMessage.add(OutputViewMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
		beforeDiscountMessage.add(String.format("%,d원", totalOrderAmount));

		System.out.println(NEW_LINE + beforeDiscountMessage.toString());
	}

	public void printGiveawayMenu(Food giveaway) {
		StringJoiner giveawayMessage = new StringJoiner(NEW_LINE);
		String emptyMessage = OutputViewMessage.EVENT_PRODUCTS.getMessage() + NEW_LINE
				+ OutputViewMessage.NOTHING.getMessage();

		if (Objects.nonNull(giveaway)) {
			addToGiveawayMessage(giveawayMessage, giveaway);
		}

		giveawayMessage.setEmptyValue(emptyMessage);

		System.out.println(NEW_LINE + giveawayMessage.toString());
	}

	private void addToGiveawayMessage(StringJoiner giveawayMessage, Food giveaway) {
		giveawayMessage.add(OutputViewMessage.EVENT_PRODUCTS.getMessage());
		giveawayMessage.add(String.format("%s %d개", giveaway.getName(), 1));
	}

	public void printBenefitDetails(Benefits benefits) {
		StringJoiner benefitDetailsMessage = new StringJoiner(NEW_LINE);
		String emptyMessage = OutputViewMessage.BENEFIT_DETAILS.getMessage() + NEW_LINE
				+ OutputViewMessage.NOTHING.getMessage();

		if (Objects.nonNull(benefits) && benefits.getSize() != 0) {
			addToBenefitDetailMessage(benefitDetailsMessage, benefits);
		}

		benefitDetailsMessage.setEmptyValue(emptyMessage);

		System.out.println(NEW_LINE + benefitDetailsMessage.toString());
	}

	private void addToBenefitDetailMessage(StringJoiner benefitDetailsMessage, Benefits benefits) {
		benefitDetailsMessage.add(OutputViewMessage.BENEFIT_DETAILS.getMessage());
		for (Benefit benefit : benefits.toList()) {
			String benefitEventName = benefit.event().getEventName();
			int discountAmount = benefit.benefitAmount();

			benefitDetailsMessage.add(String.format("%s : %,d원", benefitEventName, -discountAmount));
		}
	}

	public void printTotalBenefitAmount(int totalBenefitAmount) {
		StringJoiner benefitsPrcieMessage = new StringJoiner(NEW_LINE);

		benefitsPrcieMessage.add(OutputViewMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
		benefitsPrcieMessage.add(String.format("%,d원", -totalBenefitAmount));

		System.out.println(NEW_LINE + benefitsPrcieMessage.toString());
	}

	public void printTotalPaymentAmountAfterDiscount(int totalPayment) {
		StringJoiner totalPaymentMessage = new StringJoiner(NEW_LINE);

		totalPaymentMessage.add(OutputViewMessage.TOTAL_PAYMENT_AMOUNT_AFTER_DISCOUNT.getMessage());
		totalPaymentMessage.add(String.format("%,d원", totalPayment));

		System.out.println(NEW_LINE + totalPaymentMessage.toString());
	}

	public void printEventBadge(Badge badge) {
		StringJoiner eventBadgeMessage = new StringJoiner(NEW_LINE);
		String emptyMessage = OutputViewMessage.EVENT_BADGE.getMessage() + NEW_LINE
				+ OutputViewMessage.NOTHING.getMessage();

		if (Objects.nonNull(badge)) {

			eventBadgeMessage.add(OutputViewMessage.EVENT_BADGE.getMessage());
			eventBadgeMessage.add(badge.badgeName());
		}

		eventBadgeMessage.setEmptyValue(emptyMessage);

		System.out.println(NEW_LINE + eventBadgeMessage.toString());
	}

	public void printErrorMessage(Exception e) {
		System.out.println(e.getMessage());
	}
}