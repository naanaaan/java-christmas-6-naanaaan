package christmas.service.benefit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateSumServiceTest {

	private CalculateSumService calculateSumService;

	@BeforeEach
	void setUp() {
		calculateSumService = new CalculateSumService();
	}

	@DisplayName("합계를 확인한다.")
	@Test
	void checkSum() {
		int result = calculateSumService.calculateSum(1000, 2023, 2400);
		assertEquals(result, 5423);
	}
}