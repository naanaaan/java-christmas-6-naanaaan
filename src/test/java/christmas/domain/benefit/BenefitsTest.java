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
		Benefit benefit1 = new Benefit(DecemberEvent.DDAY_DISCOUNT, 1000);
		Benefit benefit2 = new Benefit(DecemberEvent.WEEKDAY_DISCOUNT, 0);
		Benefit benefit3 = new Benefit(DecemberEvent.GIVEAWAY_EVENT, 10000);
		Benefit benefit4 = new Benefit(DecemberEvent.GIVEAWAY_EVENT, 2000);
		Benefit benefit5 = new Benefit(DecemberEvent.GIVEAWAY_EVENT, 0);

		Benefits benefits = new Benefits(List.of(benefit1, benefit2, benefit3, benefit4, benefit5));

		assertEquals(3, benefits.getSize());
		assertTrue(benefits.toList().contains(benefit1));
		assertTrue(benefits.toList().contains(benefit3));
		assertTrue(benefits.toList().contains(benefit4));
	}

	@DisplayName("총할인 금액을 확인한다.")
	@CsvSource(value = { "2400,2023,0,4423", "1000,0,0,1000", "2300,2023,0,4323" }, delimiter = ',')
	@ParameterizedTest
	void checkTotalDiscountAmount(int dDay, int weekend, int special, int expect) {
		Benefit dDayBenefit = new Benefit(DecemberEvent.DDAY_DISCOUNT, dDay);
		Benefit weekendBenefit = new Benefit(DecemberEvent.WEEKEND_DISCOUNT, weekend);
		Benefit specialBenefit = new Benefit(DecemberEvent.SPECIAL_DISCOUNT, special);
		Benefit giveawayBenefit = new Benefit(DecemberEvent.GIVEAWAY_EVENT, FoodMenu.CHAMPAGNE.getFoodPrice() * -1);
		Benefits benefits = new Benefits(List.of(dDayBenefit, weekendBenefit, specialBenefit, giveawayBenefit));
		int totalDiscountAmount = benefits.getTotalDiscountAmount();

		assertEquals(expect, totalDiscountAmount);
	}

	@DisplayName("총혜택 금액을 확인한다.")
	@CsvSource(value = { "1000,0,10000,11000", "2000,1000,10000,13000" }, delimiter = ',')
	@ParameterizedTest
	void checkTotalBenefitAmount(int benefitAmount, int benefitAmount2, int benefitAmount3, int expect) {
		Benefit benefit1 = new Benefit(DecemberEvent.DDAY_DISCOUNT, benefitAmount);
		Benefit benefit2 = new Benefit(DecemberEvent.WEEKDAY_DISCOUNT, benefitAmount2);
		Benefit benefit3 = new Benefit(DecemberEvent.GIVEAWAY_EVENT, benefitAmount3);

		Benefits benefits = new Benefits(List.of(benefit1, benefit2, benefit3));
		int totalBenefitAmount = benefits.getTotalBenefitAmount();

		assertEquals(expect, totalBenefitAmount);
	}
}