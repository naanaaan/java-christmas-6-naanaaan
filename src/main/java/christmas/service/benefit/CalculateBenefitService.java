package christmas.service.benefit;

import java.util.Objects;

import christmas.domain.food.Food;

public class CalculateBenefitService {

	public int calculateTotalBenefitAmount(int totalDiscountAmount, Food giveaway) {
		int giveawayPrice = 0;

		if (Objects.nonNull(giveaway)) {
			giveawayPrice = giveaway.getPrice() * -1;
		}

		return totalDiscountAmount + giveawayPrice;
	}

	public int cacluclateTotalPaymentAmount(int totalOrderAmount, int totalDiscountAmount) {
		return totalOrderAmount + totalDiscountAmount;
	}
}