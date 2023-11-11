package christmas.service.benefit;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.Event;
import christmas.domain.food.Food;
import christmas.domain.food.Menu;

public class GiveawayEventService {

	private static final Event EVENT = Event.GIVEAWAY_EVENT;
	private static final Menu GIVEAWAY = Menu.CHAMPAGNE;

	public Benefit getBenefit() {
		int benefitAmount = GIVEAWAY.getPrice();

		return new Benefit(EVENT, benefitAmount * -1);
	}

	public Food getGiveaway() {
		return GIVEAWAY.toFood();
	}
}