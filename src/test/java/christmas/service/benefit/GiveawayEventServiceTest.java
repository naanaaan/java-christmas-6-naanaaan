package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@DisplayName("증정품이 샴페인인지 확인한다.")
	@Test
	void checkGiveaway() {
		Food giveaway = giveawayEventService.getGiveaway();

		assertEquals(giveaway, Menu.CHAMPAGNE.toFood());
	}
}