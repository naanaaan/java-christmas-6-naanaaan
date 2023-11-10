package christmas.view.Input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int inputVisitDate() {
		System.out.println(InputMessage.INPUT_VISIT_DATE.getMessage());

		String inputValue = Console.readLine();

		validateVisitDate(inputValue);

		return Integer.parseInt(inputValue);
	}

	public String inputMenus() {
		System.out.println(InputMessage.INPUT_MENUS.getMessage());

		String inputValue = Console.readLine();
		String[] test = inputValue.split(",");
		for (String value : test) {
			validateMenus(value);
		}

		return inputValue;
	}

	private void validateVisitDate(String inputValue) {
		InputValidator.validateIsEmpty(inputValue);
		InputValidator.validateNumberFormat(inputValue);
	}

	private void validateMenus(String inputValue) {
		InputValidator.validateOrderFormat(inputValue);
	}
}