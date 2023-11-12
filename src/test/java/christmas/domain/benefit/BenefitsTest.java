package christmas.domain.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.food.FoodMenu;

class BenefitsTest {

	@DisplayName("헤택금액이이 0이 아닌 혜택들을 반환하는지 확인한다.")
	@Test
	void checkNotZeroBenefitAmountBenefits() {
		Benefit benefit1 = new Benefit(DecemberEvent.DDAY_DISCOUNT, -1000);
		Benefit benefit2 = new Benefit(DecemberEvent.WEEKDAY_DISCOUNT, 0);
		Benefit benefit3 = new Benefit(DecemberEvent.GIVEAWAY_EVENT, -10000);

		Benefits benefits = new Benefits(List.of(benefit1, benefit2, benefit3));

		assertEquals(2, benefits.getSize());
		assertTrue(benefits.toList().contains(benefit1));
		assertTrue(benefits.toList().contains(benefit3));
	}

	@DisplayName("총할인 금액을 확인한다.")
	@CsvSource(value = { "-2400,-2023,0,-4423", "-1000,0,0,-1000", "-2300,-2023,0,-4323" }, delimiter = ',')
	@ParameterizedTest
	void checkTotalDiscountAmount(int dDay, int weekend, int special, int expect) {
		Benefit dDayBenefit = new Benefit(DecemberEvent.DDAY_DISCOUNT, dDay);
		Benefit weekendBenefit = new Benefit(DecemberEvent.WEEKEND_DISCOUNT, weekend);
		Benefit specialBenefit = new Benefit(DecemberEvent.SPECIAL_DISCOUNT, special);
		Benefit giveawayBenefit = new Benefit(DecemberEvent.GIVEAWAY_EVENT, FoodMenu.CHAMPAGNE.getPrice() * -1);
		Benefits benefits = new Benefits(List.of(dDayBenefit, weekendBenefit, specialBenefit, giveawayBenefit));
		int totalDiscountAmount = benefits.getTotalDiscountAmount();

		assertEquals(expect, totalDiscountAmount);
	}
}
