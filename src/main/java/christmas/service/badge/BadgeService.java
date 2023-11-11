package christmas.service.badge;

import java.util.Optional;

import christmas.domain.EventBadge;

public class BadgeService {

	public Optional<EventBadge> getBadgeByTotalBenefitsPrice(int totalBenefitPrice) {
		Optional<EventBadge> badge = EventBadge.getBadgeByTotalBenefitsPrice(totalBenefitPrice);

		return badge;
	}
}