package christmas.service.badge;

import java.util.Optional;

import christmas.domain.EventBadge;

public class BadgeService {

	public Optional<EventBadge> getBadgeByTotalBenefitAmount(int totalBenefitAmount) {
		Optional<EventBadge> badge = EventBadge.getBadgeByTotalBenefitAmount(totalBenefitAmount);

		return badge;
	}
}