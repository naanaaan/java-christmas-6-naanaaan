package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DecemberEvent;
import christmas.domain.food.Food;
import christmas.domain.food.FoodMenu;

public class GiveawayEventServiceTest {

	private GiveawayEventService giveawayEventService;

	@BeforeEach
	void setUp() {
		giveawayEventService = new GiveawayEventService();
	}

	@DisplayName("증정헤택의 이벤트와 헤택금액을 확인한다.")
	@Test
	void checkGiveawayBenefitEventAndAmount() {
		Benefit benefit = giveawayEventService.getBenefit();

		assertEquals(DecemberEvent.GIVEAWAY_EVENT, benefit.event());
		assertEquals(FoodMenu.CHAMPAGNE.getPrice(), benefit.benefitAmount());
	}

	@DisplayName("증정품이 샴페인인지 확인한다.")
	@Test
	void checkGiveaway() {
		Food giveaway = giveawayEventService.getGiveaway();

		assertEquals(giveaway.getName(), FoodMenu.CHAMPAGNE.getName());
	}
}