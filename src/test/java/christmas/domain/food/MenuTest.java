package christmas.domain.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.food.Menu;

public class MenuTest {

	@DisplayName("메뉴 이름에 해당하는 Enum 객체를 확인한다.")
	@CsvSource(value = { "양송이수프, MUSHROOM_SOUP", "티본스테이크, T_BONE_STEAK", "크리스마스파스타, CHRISTMAS_PASTA",
			"초코케이크, CHOCO_CAKE", "아이스크림, ICE_CREAM", "제로콜라, ZERO_COLA" }, delimiter = ',')
	@ParameterizedTest
	void checkGetMenuByName(String menuName, Menu expect) {
		Optional<Menu> menu = Menu.getMenuByName(menuName);

		if (menu.isPresent()) {
			assertEquals(expect, menu.get());
			assertTrue(menu.get().getName().equals(menuName));
		}
	}
}