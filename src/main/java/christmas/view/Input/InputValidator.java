package christmas.view.Input;

import java.util.Set;
import java.util.regex.Pattern;

import christmas.domain.Menu;
import christmas.util.ErrorMessage;

public class InputValidator {

	private static final Pattern ORDER_FORMAT = Pattern.compile(
			"^([가-힣]+)-([1-9]\\d*)" + "(,([가-힣]+)-([1-9]\\d*))*$");
	private static final Pattern NUMBER_FORMAT = Pattern.compile("^-?\\d+$");

	private InputValidator() {
		throw new AssertionError();
	}

	public static void validateOrderFormat(String inputValue) {
		if (!ORDER_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.VALID_ORDER_MENU.getMessage());
		}
	}

	public static void validateValidFoodName(String inputValue) {
		if (!Menu.checkByName(inputValue)) {
			throw new IllegalArgumentException(ErrorMessage.VALID_ORDER_MENU.getMessage());
		}
	}

	public static void validateDuplicateFoodName(Set<String> checker, String foodName) {
		if (!checker.add(foodName)) {
			throw new IllegalArgumentException(ErrorMessage.VALID_ORDER_MENU.getMessage());
		}

	}

	public static void validateNumberFormat(String inputValue) {
		if (!NUMBER_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.VALID_VISITDATE.getMessage());
		}
	}

	public static void validateIsEmpty(String inputValue) {
		if (isEmpty(inputValue)) {
			throw new IllegalArgumentException(ErrorMessage.VALID_VISITDATE.getMessage());
		}
	}

	private static boolean isEmpty(String confirmationTarget) {
		return confirmationTarget == null || confirmationTarget.isBlank();
	}
}
