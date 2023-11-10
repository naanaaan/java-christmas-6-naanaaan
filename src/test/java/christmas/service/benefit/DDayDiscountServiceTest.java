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
	
	@DisplayName("test")
	@CsvSource(value = {"1,1000", "26,3400", "25,3400", "20,2900"}, delimiter = ',')
	@ParameterizedTest
	void test(int day, int expect) {
		int discountAmount = dDayDiscountService.discount(day);
		
		assertEquals(discountAmount, expect);
	}
}
