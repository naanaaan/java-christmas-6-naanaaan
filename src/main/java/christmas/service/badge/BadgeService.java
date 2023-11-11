package christmas.service.badge;

import christmas.domain.Badge;
import christmas.domain.EventBadge;

public class BadgeService {

	public Badge getBadgeByTotalBenefitsAmount(int totalBenefitsAmount) {
		Badge badge = EventBadge.getBadgeByTotalBenefitsAmount(totalBenefitsAmount).tobadge();

		return badge;
	}
}