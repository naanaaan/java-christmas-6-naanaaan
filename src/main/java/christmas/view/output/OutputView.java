package christmas.view.output;

import java.util.Map;
import java.util.StringJoiner;

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

}