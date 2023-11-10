package christmas.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.Foods;

public class CreateServiceTest {
	
	private CreateService service;
	
	@BeforeEach
	void setUpt() {
		service = new CreateService();
	}
	
	@DisplayName("음식들을 생성하고 사이즈를 확인한다.")
	@CsvSource(value = {"타파스-1,제로콜라-1;2", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1;5"}, delimiter = ';')
	@ParameterizedTest
	void test(String foodsAndNumbers, int expect) {
		assertDoesNotThrow(() -> {
			Foods foods = service.createFoods(foodsAndNumbers);
			assertEquals(foods.getFoodsSize(), expect);
		});
	}
}
