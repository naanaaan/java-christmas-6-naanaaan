package christmas.domain.badge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EventBadgeTest {

	@DisplayName("총혜택 금액에 따라 뱃지를 부여한다.")
	@CsvSource(value = { "-6000,별", "11000,트리", "-20000,산타", "25000,산타" }, delimiter = ',')
	@ParameterizedTest
	void checkBadgeByTotalBenefitAmount(int totalBenefitAmount, String expect) {
		Optional<EventBadge> badge = EventBadge.getBadgeByTotalBenefitAmount(totalBenefitAmount);
		String badgeName = "";

		if (badge.isPresent()) {
			badgeName = badge.get().getBadgeName();
		}

		assertEquals(badgeName, expect);
	}
}