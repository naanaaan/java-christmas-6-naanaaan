package christmas.domain.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
