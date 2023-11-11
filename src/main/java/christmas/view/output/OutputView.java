package christmas.view.output;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import christmas.domain.Badge;
import christmas.domain.Benefit;
import christmas.domain.Food;
import christmas.domain.VisitDate;

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
			String foodName = entry.getKey().name();
			int number = entry.getValue();

			orderMenuMessage.add(String.format("%s %d개", foodName, number));
		}

		System.out.println(NEW_LINE + orderMenuMessage.toString());
	}

	public void printTotalOrderAmountBeforeDiscount(int totalAmount) {
		StringJoiner beforeDiscountMessage = new StringJoiner(NEW_LINE);
		beforeDiscountMessage.add(OutputViewMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
		beforeDiscountMessage.add(String.format("%,d원", totalAmount));

		System.out.println(NEW_LINE + beforeDiscountMessage.toString());
	}

	public void printGiveawayMenu(Food giveaway) {
		StringJoiner giveawayMessage = new StringJoiner(NEW_LINE);
		String empty = OutputViewMessage.EVENT_PRODUCTS.getMessage() + NEW_LINE
				+ OutputViewMessage.NOTHING.getMessage();

		if (Objects.nonNull(giveaway)) {
			addToGiveawayMessage(giveawayMessage, giveaway);
		}

		giveawayMessage.setEmptyValue(empty);

		System.out.println(NEW_LINE + giveawayMessage.toString());
	}

	private void addToGiveawayMessage(StringJoiner giveawayMessage, Food giveaway) {
		giveawayMessage.add(OutputViewMessage.EVENT_PRODUCTS.getMessage());
		giveawayMessage.add(String.format("%s %,d", giveaway.name(), giveaway.price()));
	}

	public void printBenefitDetails(List<Benefit> benefits) {
		StringJoiner benefitDetailsMessage = new StringJoiner(NEW_LINE);
		String empty = OutputViewMessage.BENEFIT_DETAILS.getMessage() + NEW_LINE
				+ OutputViewMessage.NOTHING.getMessage();

		if (Objects.nonNull(benefits) && benefits.size() != 0) {
			addToBenefitDetailMessage(benefitDetailsMessage, benefits);
		}

		benefitDetailsMessage.setEmptyValue(empty);

		System.out.println(NEW_LINE + benefitDetailsMessage.toString());
	}

	private void addToBenefitDetailMessage(StringJoiner benefitDetailsMessage, List<Benefit> benefits) {
		benefitDetailsMessage.add(OutputViewMessage.BENEFIT_DETAILS.getMessage());
		for (Benefit benefit : benefits) {
			String benefitEventName = benefit.event().getName();
			int discountAmount = benefit.discountAmount();

			benefitDetailsMessage.add(String.format("%s : %,d원", benefitEventName, discountAmount));
		}
	}
}