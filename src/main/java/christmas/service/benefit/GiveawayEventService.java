package christmas.service.benefit;

import java.util.List;
import java.util.stream.Stream;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.Food;
import christmas.domain.Menu;

public class GiveawayEventService {
	
	private static final Event EVENT = Event.GIVEAWAY_EVENT;
	private static final Food EVENT_PRODUCT = Menu.CHAMPAGNE.toFood();
	private static final int GIVE_COUNT = 1;

	public Benefit getBenefit() {
		int discountAmount = 0;
		List<Food> giveaways = getGiveaways();
		
		discountAmount = calculateSumEventProductPrice(giveaways);
		
		return new Benefit(EVENT, discountAmount * -1);
	}
	
	public List<Food> getGiveaways() {
		return Stream.generate(() -> EVENT_PRODUCT)
				.limit(GIVE_COUNT)
				.toList();
	}

	private int calculateSumEventProductPrice(List<Food> giveaways) {
		return giveaways.stream()
				.mapToInt(food -> food.price())
				.sum();
	}
}