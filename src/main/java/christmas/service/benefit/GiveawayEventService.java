package christmas.service.benefit;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DecemberEvent;
import christmas.domain.food.Food;
import christmas.domain.food.FoodMenu;

public class GiveawayEventService {

	private static final DecemberEvent EVENT = DecemberEvent.GIVEAWAY_EVENT;
	private static final FoodMenu GIVEAWAY = FoodMenu.CHAMPAGNE;

	public Benefit getBenefit() {
		int benefitAmount = GIVEAWAY.getPrice();

		return new Benefit(EVENT, benefitAmount * -1);
	}

	public Food getGiveaway() {
		return GIVEAWAY.toFood();
	}
}