package christmas.service.benefit;

import java.util.List;
import java.util.stream.Stream;

import christmas.domain.Food;
import christmas.domain.Menu;

public class GiveawayEventService {

	private static final Food EVENT_PRODUCT = Menu.CHAMPAGNE.toFood();
	private static final int GIVE_COUNT = 1;

	public List<Food> giveEventProduct() {
		return Stream.generate(() -> EVENT_PRODUCT)
				.limit(GIVE_COUNT)
				.toList();
	}

	public int calculateSumEventProductPrice(List<Food> eventProducts) {
		return eventProducts.stream()
				.mapToInt(food -> food.price())
				.sum();
	}
}