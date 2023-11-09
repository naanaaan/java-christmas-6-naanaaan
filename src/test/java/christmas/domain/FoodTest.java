package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoodTest {

	@DisplayName("메뉴에 없는 음식을 생성할 때 예외가 발생한다.")
	@Test
	void crateFoodByNonexistentMenu() {
		assertThatThrownBy(() -> new Food(FoodCategory.APPETIZER, "에피타이저", 2000))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("메뉴에 있는 음식을 생성할 때 정상 작동한다.")
	@Test
	void checkNomalOperation1() {
		Food food = Menu.BBQ_RIBS.toFood();
	}
}