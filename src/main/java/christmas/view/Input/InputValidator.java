package christmas.view.Input;

import java.util.regex.Pattern;

import christmas.service.ErrorMessage;

public class InputValidator {

	private static final Pattern ORDER_PATTERN = Pattern.compile("([가-힣]+)-([0-9]+)");
	private static final Pattern NUMBER_FORMAT = Pattern.compile("^-?\\d+$");

	private InputValidator() {
		throw new AssertionError();
	}

	public static void validateOrderFormat(String inputValue) {
		if (!ORDER_PATTERN.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.ORDER_MENU.getMessage());
		}
	}

	public static void validateNumberFormat(String inputValue) {
		if (!NUMBER_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.VISITDATE.getMessage());
		}
	}

	public static void validateIsEmpty(String inputValue) {
		if (isEmpty(inputValue)) {
			throw new IllegalArgumentException("값이 비어있습니다");
		}
	}

	private static boolean isEmpty(String confirmationTarget) {
		return confirmationTarget == null || confirmationTarget.isBlank();
	}
}
