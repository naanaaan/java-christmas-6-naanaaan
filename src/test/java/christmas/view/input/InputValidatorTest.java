package christmas.view.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import christmas.service.ErrorMessage;
import christmas.view.Input.InputValidator;

public class InputValidatorTest {

	@DisplayName("주문 형태(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)가 아닐 때 예외처리한다.")
	@ValueSource(strings = { "음식-0 음식-3 음식-2", "음식 0, 음식 1, 음식 2" })
	@ParameterizedTest
	void checkOrderFormat(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateOrderFormat(inputValue))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.ORDER_MENU.getMessage());
	}

	@DisplayName("주문 형태(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)일 때 정상작동한다.")
	@ValueSource(strings = { "음식-1,음식-1,음식-2", "음식-10,음식-2" })
	@ParameterizedTest
	void checkNomalOperation1(String inputValue) {
		assertDoesNotThrow(() -> InputValidator.validateOrderFormat(inputValue));
	}

	@DisplayName("음식의 갯수가 0이하거나 문자일 때 예외처리한다.")
	@ValueSource(strings = { "음식1-0", "음식1,a, 음식1--1" })
	@ParameterizedTest
	void checkFoodNumberZero(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateOrderFormat(inputValue))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.ORDER_MENU.getMessage());
	}

	@DisplayName("음식의 갯수가 1이상일 때 정상작동한다.")
	@ValueSource(strings = { "음식-1,음식-2,음식-10", "음식-100,음식-25" })
	@ParameterizedTest
	void checkNomalOperation2(String inputValue) {
		assertDoesNotThrow(() -> InputValidator.validateOrderFormat(inputValue));
	}

	@DisplayName("음식이 메뉴에 없을 떄 예외처리한다.")
	@ValueSource(strings = { "스테이크", "블루베리스무디" })
	@ParameterizedTest
	void checkValidFoodName(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateValidFoodName(inputValue))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.ORDER_MENU.getMessage());
	}

	@DisplayName("음식이 메뉴에 있을 때 정상작동한다.")
	@ValueSource(strings = { "초코케이크", "타파스", "티본스테이크" })
	@ParameterizedTest
	void checkNomalOperation3(String inputValue) {
		assertDoesNotThrow(() -> InputValidator.validateValidFoodName(inputValue));
	}

	@DisplayName("중복되는 음식 입력시 예외처리한다.")
	@MethodSource("createcheckValidFoodNameMethodParameter")
	@ParameterizedTest
	void checkInputDuplicateFoodName(List<String> foodNameList) {
		Set<String> duplicateChecker = new HashSet<>();
		assertThatThrownBy(() -> {
			for (String foodName : foodNameList) {
				InputValidator.validateDuplicateFoodName(duplicateChecker, foodName);
			}
		}).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessage.ORDER_MENU.getMessage());
	}

	static Stream<Arguments> createcheckValidFoodNameMethodParameter() {
		return Stream.of(Arguments.of(List.of("팝콘", "스테이크", "팝콘"), Arguments.of(List.of("스테이크", "스테이크", "팝콘"))));
	}

	@DisplayName("중복되는 않은 음식 입력시 정상작동한다.")
	@MethodSource("createcheckNomalOperation4MethodParameter")
	@ParameterizedTest
	void checkNomalOperation4(List<String> foodNameList) {
		Set<String> duplicateChecker = new HashSet<>();
		assertDoesNotThrow(() -> {
			for (String foodName : foodNameList) {
				InputValidator.validateDuplicateFoodName(duplicateChecker, foodName);
			}
		});
	}

	static Stream<Arguments> createcheckNomalOperation4MethodParameter() {
		return Stream.of(Arguments.of(List.of("팝콘", "스테이크", "치킨"), Arguments.of(List.of("족발", "스테이크", "팝콘"))));
	}

	@DisplayName("숫자가 아닌 문자가 포함되어 있으면 예외처리한다.")
	@ValueSource(strings = { "#12", "0s12", ",.!" })
	@ParameterizedTest
	void checkNumberFormat(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateNumberFormat(inputValue))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessage.VISITDATE.getMessage());
	}

	@DisplayName("문자가 아닌 숫자만 입력시 정상작동한다.")
	@ValueSource(strings = { "1", "0", "-1", "10000" })
	@ParameterizedTest
	void checkNomalOperation5(String inputValue) {
		assertDoesNotThrow(() -> InputValidator.validateNumberFormat(inputValue));
	}

	@DisplayName("값이 비어있을 때 예외처리한다.")
	@ValueSource(strings = { "", " ", "     " })
	@ParameterizedTest
	void checkIsEmpty(String inputValue) {
		assertThatThrownBy(() -> InputValidator.validateIsEmpty(inputValue))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessage.VISITDATE.getMessage());
	}

	@DisplayName("값이 존재할 때 정상작동한다.")
	@ValueSource(strings = { "1", "a", "치킨먹고싶다...", "족발" })
	@ParameterizedTest
	void checkNomalOperation6(String inputValue) {
		assertDoesNotThrow(() -> InputValidator.validateIsEmpty(inputValue));
	}
}
