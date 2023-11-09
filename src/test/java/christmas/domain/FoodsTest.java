package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FoodsTest {

	@DisplayName("Foods의 사이즈가 1 ~ 20이 아닐 때 예외가 발생한다.")
	@MethodSource("createCreateFoodByOverSizeMethodParameter")
	@ParameterizedTest
	void createFoodByOverSize(List<Food> foods) {
		assertThatThrownBy(() -> new Foods(foods))
				.isInstanceOf(IllegalArgumentException.class);
	}

	static Stream<Arguments> createCreateFoodByOverSizeMethodParameter() {
		List<Food> size0Foods = new ArrayList<>();
		List<Food> size21Foods = generateFoods(Menu.BBQ_RIBS, 21);

		return Stream.of(Arguments.of(size0Foods), Arguments.of(size21Foods));
	}

	@DisplayName("Foods의 사이즈가 1 ~ 20일 때 정상 작동한다.")
	@MethodSource("createCheckNomalOperation1Parameter")
	@ParameterizedTest
	void checkNomalOperation1(List<Food> foods) {
		new Foods(foods);
	}

	static Stream<Arguments> createCheckNomalOperation1Parameter() {
		List<Food> size1Foods = new ArrayList<>(List.of(Menu.BBQ_RIBS.toFood()));
		List<Food> size19Foods = generateFoods(Menu.BBQ_RIBS, 19);

		return Stream.of(Arguments.of(size1Foods), Arguments.of(size19Foods));
	}

	@DisplayName("음료수만 존재할 때 예외가 발생한다.")
	@MethodSource("createCreateFoodByOnlyBeverageMethodParameter")
	@ParameterizedTest
	void createFoodByOnlyBeverage(List<Food> foods) {
		assertThatThrownBy(() -> new Foods(foods))
				.isInstanceOf(IllegalArgumentException.class);
	}

	static Stream<Arguments> createCreateFoodByOnlyBeverageMethodParameter() {
		List<Food> onlyBeverages1 = generateFoods(Menu.ZERO_COLA, 2);
		List<Food> onlyBeverages2 = generateFoods(Menu.RED_WINE, 10);

		return Stream.of(Arguments.of(onlyBeverages1), Arguments.of(onlyBeverages2));
	}
	
	@DisplayName("음료수만 존재하지 않을 때 정상 작동한다.")
	@MethodSource("createCheckNomalOperation2Parameter")
	@ParameterizedTest
	void checkNomalOperation2(List<Food> foods) {
		new Foods(foods);
	}

	static Stream<Arguments> createCheckNomalOperation2Parameter() {
		List<Food> foods1 = generateFoods(Menu.BBQ_RIBS, 2);
		List<Food> foods2 = generateFoods(Menu.CAESAR_SALAD, 10);

		return Stream.of(Arguments.of(foods1), Arguments.of(foods2));
	}

	private static List<Food> generateFoods(Menu menu, int limitNumber) {
		return Stream.generate(() -> menu.toFood()).limit(limitNumber).toList();
	}
}
