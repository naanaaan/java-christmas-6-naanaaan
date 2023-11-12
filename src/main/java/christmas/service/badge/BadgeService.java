package christmas.service.badge;

import java.util.Optional;

import christmas.domain.badge.Badge;
import christmas.domain.badge.EventBadge;

public class BadgeService {

	public Badge getBadgeByTotalBenefitAmount(int totalBenefitAmount) {
		Optional<EventBadge> badge = EventBadge.getBadgeByTotalBenefitAmount(totalBenefitAmount);

		if (badge.isPresent()) {
			return badge.get().tobadge();
		}

		return null;
	}
}