package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DDayDiscountServiceTest {

	private DDayDiscountService dDayDiscountService;

	@BeforeEach
	void setUp() {
		dDayDiscountService = new DDayDiscountService();
	}

	@DisplayName("디데이 할인 금액을 확인한다.")
	@CsvSource(value = { "1,1000", "24,3300", "26,0", "25,3400", "31,0" }, delimiter = ',')
	@ParameterizedTest
	void checkDDayDiscountAmount(int day, int expect) {
		int discountAmount = dDayDiscountService.getBenefit(day).benefitAmount();

		assertEquals(expect, discountAmount);
	}
}