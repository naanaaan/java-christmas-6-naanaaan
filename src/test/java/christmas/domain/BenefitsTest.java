package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.Event;

class BenefitsTest {

	@DisplayName("할인가격이 0이 아닌 혜택들을 반환하는지 확인한다.")
	@Test
	void checkNotZeroDiscountAmountBenefits() {
		Benefit benefit1 = new Benefit(Event.DDAY_DISCOUNT, -1000);
		Benefit benefit2 = new Benefit(Event.WEEKDAY_DISCOUNT, 0);
		Benefit benefit3 = new Benefit(Event.GIVEAWAY_EVENT, -10000);

		Benefits benefitsObject = new Benefits(List.of(benefit1, benefit2, benefit3));

		List<Benefit> result = benefitsObject.getNotZeroDiscountAmount();

		assertEquals(2, result.size());
		assertTrue(result.contains(benefit1));
		assertTrue(result.contains(benefit3));

	}
}
