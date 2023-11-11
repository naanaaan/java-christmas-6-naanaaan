package christmas.service.benefit;

import java.util.List;
import java.util.Objects;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.Food;

public class CalcualteBenefitService {

	public int calculateTotalDiscountPrice(List<Benefit> benefits) {
		return benefits.stream().filter(benefit -> benefit.event() != Event.GIVEAWAY_EVENT)
				.mapToInt(benefit -> benefit.discountPrice()).sum();
	}

	public int calculateTotalBenefitPrice(int totalDiscountPrice, Food giveaway) {
		int gitveawayBenefitPrice = 0;

		if (Objects.nonNull(giveaway)) {
			gitveawayBenefitPrice = giveaway.price() * -1;
		}

		return totalDiscountPrice + gitveawayBenefitPrice;
	}

	public int cacluclateTotalPaymentPrice(int totalOrderPrice, int totalDiscountPrice) {
		return totalOrderPrice + totalDiscountPrice;
	}
}
