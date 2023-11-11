package christmas.service.benefit;

import java.util.List;
import java.util.Objects;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.Food;

public class CalcualteBenefitService {

	public int calculateTotalDiscountAmount(List<Benefit> benefits) {
		return benefits.stream().filter(benefit -> benefit.event() != Event.GIVEAWAY_EVENT)
				.mapToInt(benefit -> benefit.benefitAmount()).sum();
	}

	public int calculateTotalBenefitAmount(int totalDiscountPrice, Food giveaway) {
		int gitveawayBenefitPrice = 0;

		if (Objects.nonNull(giveaway)) {
			gitveawayBenefitPrice = giveaway.price() * -1;
		}

		return totalDiscountPrice + gitveawayBenefitPrice;
	}

	public int cacluclateTotalPaymentAmount(int totalOrderPrice, int totalDiscountPrice) {
		return totalOrderPrice + totalDiscountPrice;
	}
}
