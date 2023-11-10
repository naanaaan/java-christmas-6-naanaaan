package christmas.view.Input;

import java.util.regex.Pattern;

public class InputValidator {

	private static final Pattern ORDER_PATTERN = Pattern.compile("([가-힣]+)-([0-9]+)");
	public static final Pattern NUMBER_FORMAT = Pattern.compile("^-?\\d+$");

	private InputValidator() {
		throw new AssertionError();
	}

	public static void validateOrderFormat(String inputValue) {
		if (!ORDER_PATTERN.matcher(inputValue).matches()) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateNumberFormat(String inputValue) {
		if (!NUMBER_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateIsEmpty(String inputValue) {
		if (isEmpty(inputValue)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isEmpty(String confirmationTarget) {
		return confirmationTarget == null || confirmationTarget.isBlank();
	}
}
