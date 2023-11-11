package christmas.view.Input;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import christmas.service.ErrorMessage;

public class InputView {

	public int inputVisitDate() {
		System.out.println(InputMessage.INPUT_VISIT_DATE.getMessage());

		String inputValue = Console.readLine();

		validateInputVisitDate(inputValue);

		return Integer.parseInt(inputValue);
	}

	public String inputMenus() {
		System.out.println(InputMessage.INPUT_MENUS.getMessage());

		String inputValue = Console.readLine();

		validateInputMenus(inputValue);

		return inputValue;
	}

	private void validateInputVisitDate(String inputValue) {
		InputValidator.validateIsEmpty(inputValue);
		InputValidator.validateNumberFormat(inputValue);
	}

	private void validateInputMenus(String inputValue) {
		Set<String> duplicateChecker = new HashSet<>();

		InputValidator.validateOrderFormat(inputValue);

		String[] separetedValue = inputValue.split(",");

		for (String foodNameAndNumbers : separetedValue) {
			String[] foodNameAndNumber = foodNameAndNumbers.split("-");
			validateFoodName(duplicateChecker, foodNameAndNumber[0]);
		}
	}

	private void validateFoodName(Set<String> duplicateChecker, String foodName) {
		InputValidator.validateValidFoodName(foodName);
		InputValidator.validateDuplicateFoodName(duplicateChecker, foodName);
	}
}