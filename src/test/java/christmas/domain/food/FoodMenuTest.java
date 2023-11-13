package christmas.domain.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FoodMenuTest {

	@DisplayName("음식이름이 메뉴에 있는지 확인한다.")
	@CsvSource(value = { "초코케이크,true", "족발,false", "치킨,false", "시저샐러드,true", "레드와인,true" }, delimiter = ',')
	@ParameterizedTest
	void checkNameByMenuExists(String name, boolean expect) {
		boolean result = FoodMenu.checkByName(name);

		assertEquals(expect, result);
	}

	@DisplayName("메뉴 이름에 해당하는 Enum 객체를 확인한다.")
	@CsvSource(value = { "양송이수프, MUSHROOM_SOUP", "티본스테이크, T_BONE_STEAK", "크리스마스파스타, CHRISTMAS_PASTA",
			"초코케이크, CHOCO_CAKE", "아이스크림, ICE_CREAM", "제로콜라, ZERO_COLA" }, delimiter = ',')
	@ParameterizedTest
	void checkGetMenuByName(String menuName, FoodMenu expect) {
		Optional<FoodMenu> menu = FoodMenu.getMenuByName(menuName);

		if (menu.isPresent()) {
			assertEquals(expect, menu.get());
			assertTrue(menu.get().getName().equals(menuName));
		}
	}
}