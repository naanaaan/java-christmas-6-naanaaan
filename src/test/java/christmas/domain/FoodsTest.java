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
		 List<Food> foodsSize0 = new ArrayList<>();
		 List<Food> foodsSize26 = IntStream.rangeClosed(1, 21)
		            .mapToObj(i -> Menu.BBQ_RIBS.toFood())
		            .collect(Collectors.toList());
		 
		return Stream.of(Arguments.of(foodsSize0), Arguments.of(foodsSize26));
	}

	@DisplayName("Foods의 사이즈가 1 ~ 20일 때 정상 작동한다.")
	@MethodSource("createCheckNomalOperation1Parameter")
	@ParameterizedTest
	void checkNomalOperation1(List<Food> foods) {
		 new Foods(foods);
	}

	static Stream<Arguments> createCheckNomalOperation1Parameter() {
		 List<Food> foodsSize1 = new ArrayList<>(List.of(Menu.BBQ_RIBS.toFood()));
		 List<Food> foodsSize19 = IntStream.rangeClosed(1, 19)
		            .mapToObj(i -> Menu.BBQ_RIBS.toFood())
		            .collect(Collectors.toList());
	 
		return Stream.of(Arguments.of(foodsSize1), Arguments.of(foodsSize19));
	}
}
