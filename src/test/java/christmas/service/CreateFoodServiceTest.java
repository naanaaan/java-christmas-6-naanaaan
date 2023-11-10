package christmas.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import christmas.domain.Foods;

public class CreateFoodServiceTest {

	private CreateFoodService service;

	@BeforeEach
	void setUp() {
		service = new CreateFoodService();
	}

	@DisplayName("음식들을 생성하고 사이즈를 확인한다.")
	@CsvSource(value = { "타파스-1,제로콜라-1;2", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1;5" }, delimiter = ';')
	@ParameterizedTest
	void testCreateFoodsForCheckFoodsSize(String foodsAndNumbers, int expect) {
		assertDoesNotThrow(() -> {
			Foods foods = service.createFoods(foodsAndNumbers);
			assertEquals(foods.getFoodsSize(), expect);
		});
	}

	@DisplayName("음식이름을 중복되게 입력할 시 예외가 발생한다.")
	@ValueSource(strings = { "시저샐러드-1,시저샐러드-1", "타파스-1,타파스-2,제로콜라-1" })
	@ParameterizedTest
	void testCreateFoodsForCheckDuplicateFoodNameException(String foodsAndNumbers) {
		assertThatThrownBy(() -> service.createFoods(foodsAndNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
