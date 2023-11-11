package christmas.service.benefit;

import java.util.List;
import java.util.Objects;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.Food;

public class CalculateBenefitService {

	public int calculateTotalDiscountAmount(List<Benefit> benefits) {
		return benefits.stream().filter(benefit -> benefit.event() != Event.GIVEAWAY_EVENT)
				.mapToInt(benefit -> benefit.benefitAmount()).sum();
	}

	public int calculateTotalBenefitAmount(int totalDiscountAmount, Food giveaway) {
		int giveawayPrice = 0;

		if (Objects.nonNull(giveaway)) {
			giveawayPrice = giveaway.price() * -1;
		}

		return totalDiscountAmount + giveawayPrice;
	}

	public int cacluclateTotalPaymentAmount(int totalOrderAmount, int totalDiscountAmount) {
		return totalOrderAmount + totalDiscountAmount;
	}
}
