package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.Food;
import christmas.domain.Menu;

public class GiveawayEventServiceTest {

	private GiveawayEventService giveawayEventService;

	@BeforeEach
	void setUp() {
		giveawayEventService = new GiveawayEventService();
	}

	@DisplayName("샴페인이 증정 상품인지와 그 갯수를 확인합니다.")
	@Test
	void test() {
		List<Food> eventProducts = giveawayEventService.getGiveaways();

		assertEquals(eventProducts.size(), 1);
		assertEquals(eventProducts.get(0), Menu.CHAMPAGNE.toFood());
	}

	@DisplayName("증정 상품들의 가격들의 합을 구한다.")
	@Test
	void calculateSumEventProductPrice_ShouldReturnCorrectSum() {
		int discountAmount = giveawayEventService.getBenefit().discountAmount();

		assertEquals(discountAmount, -25000);
	}
}