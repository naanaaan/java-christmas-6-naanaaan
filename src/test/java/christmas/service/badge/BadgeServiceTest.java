package christmas.service.badge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import christmas.domain.badge.Badge;

public class BadgeServiceTest {

	private BadgeService badgeService;

	@BeforeEach
	void setUp() {
		badgeService = new BadgeService();
	}

	@DisplayName("총혜택 금액에 따른 뱃지를 확인한다.")
	@CsvSource(value = { "20000,산타", "15000,트리", "7000,별", "17000,트리", "4000,없음", "0,없음" }, delimiter = ',')
	@ParameterizedTest
	void checkBadgeByTotalBenefitAmount(int totalBenefitsAmount, String expect) {
		Badge badge = badgeService.getBadgeByTotalBenefitAmount(totalBenefitsAmount);

		if (Objects.nonNull(badge)) {
			assertEquals(expect, badge.badgeName());
		}

		if (Objects.isNull(badge)) {
			assertEquals(expect, "없음");
		}
	}
}
