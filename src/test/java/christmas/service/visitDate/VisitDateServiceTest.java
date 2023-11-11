package christmas.service.visitDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.visitDate.VisitDate;

class VisitDateServiceTest {

	private VisitDateService visitDateService;

	@BeforeEach
	void setUp() {
		visitDateService = new VisitDateService();
	}

	@Test
	@DisplayName("방문 날짜의 일자가 주어진 날짜와 동일한지 확인한다.")
	void checkDayOfVisitDateSameAsDay() {
		int day = 25;

		VisitDate visitDate = visitDateService.createVisitDate(day);
		
		assertNotNull(visitDate);
		assertEquals(day, visitDate.getDay());
	}
}
