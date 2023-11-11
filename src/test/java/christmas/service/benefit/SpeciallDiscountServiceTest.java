package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SpeciallDiscountServiceTest {

	private SpecialDiscountService specialDiscountService;

	@BeforeEach
	void setUp() {
		specialDiscountService = new SpecialDiscountService();
	}

	@DisplayName("특별 할인 날짜일 때 할인금액을 확인한다.")
	@CsvSource(value = { "3,-1000", "17,-1000", "31,-1000", "1,0" }, delimiter = ',')
	@ParameterizedTest
	void checkDiscountAmount(int day, int expect) {
		int discountAmount = specialDiscountService.getBenefit(day).benefitAmount();

		assertEquals(expect, discountAmount);
	}
}