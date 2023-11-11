package christmas.service.badge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.badge.EventBadge;

public class BadgeServiceTest {

	private BadgeService badgeService;

	@BeforeEach
	void setUp() {
		badgeService = new BadgeService();
	}

	@DisplayName("총혜택 금액에 따른 뱃지를 확인한다.")
	@CsvSource(value = { "20000,SANTA", "15000,TREE", "7000,STAR", "17000,TREE" }, delimiter = ',')
	@ParameterizedTest
	void checkBadgeByTotalBenefitAmount(int totalBenefitsAmount, EventBadge expect) {
		Optional<EventBadge> badge = badgeService.getBadgeByTotalBenefitAmount(totalBenefitsAmount);

		if (badge.isPresent()) {
			assertEquals(expect, badge.get());
		}
	}
}
