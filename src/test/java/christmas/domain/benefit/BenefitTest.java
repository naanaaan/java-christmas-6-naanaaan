package christmas.domain.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BenefitTest {

	@DisplayName("혜택 금액이 0원인지 확인한다.")
	@CsvSource(value = { "SPECIAL_DISCOUNT,1000,true", "GIVEAWAY_EVENT,25000,true", "WEEKEND_DISCOUNT,0,false",
			"DDAY_DISCOUNT,0,false" }, delimiter = ',')
	@ParameterizedTest
	void checkBenefitAmountIsNotZero(DecemberEvent event, int benefitAmount, boolean expect) {
		Benefit benefit = new Benefit(event, benefitAmount);
		assertEquals(expect, benefit.isNotZeroBenefitAmount());
	}

	@DisplayName("증정혜택인지 확인한다.")
	@CsvSource(value = { "SPECIAL_DISCOUNT,true", "GIVEAWAY_EVENT,false", "WEEKEND_DISCOUNT,true",
			"DDAY_DISCOUNT,true" }, delimiter = ',')
	@ParameterizedTest
	void checkBenefitIsNotGiveawayEventBenefit(DecemberEvent event, boolean expect) {
		Benefit benefit = new Benefit(event, 1000);
		assertEquals(expect, benefit.isNotGiveawayEventBenefit());
	}
}