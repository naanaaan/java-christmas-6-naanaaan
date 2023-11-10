package christmas.view.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import christmas.view.Input.InputValidator;

public class InputValidatorTest {

	@DisplayName("숫자가 아닌 문자가 포함되어 있으면 예외처리한다.")
	@ValueSource(strings = { "#12", "0s12", ",.!" })
	@ParameterizedTest
	void checkNumberFormat(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateNumberFormat(inputValue))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("주문 형태(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)가 아닐 때 예외처리한다.")
	@ValueSource(strings = { "음식1-0 음식2-3 음식3-2", "음식1 0, 음식2 1, 음식3 2" })
	@ParameterizedTest
	void checkOrderFormat(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateNumberFormat(inputValue))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 비어있을 때 예외처리한다.")
	@ValueSource(strings = { "", " ", "     " })
	@ParameterizedTest
	void test(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateIsEmpty(inputValue))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
