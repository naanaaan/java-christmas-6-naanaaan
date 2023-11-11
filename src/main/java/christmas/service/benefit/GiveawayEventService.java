package christmas.service.benefit;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.Food;
import christmas.domain.Menu;

public class GiveawayEventService {

	private static final Event EVENT = Event.GIVEAWAY_EVENT;
	private static final Menu GITVEAWAY = Menu.CHAMPAGNE;

	public Benefit getBenefit() {
		int discountPrice = GITVEAWAY.getPrice();

		return new Benefit(EVENT, discountPrice * -1);
	}

	public Food getGiveaway() {
		return GITVEAWAY.toFood();
	}
}