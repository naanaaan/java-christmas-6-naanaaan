package christmas.service.badge;

import christmas.domain.Badge;
import christmas.domain.EventBadge;

public class BadgeService {

	public Badge getBadgeByTotalBenefitsPrice(int totalBenefitPrice) {
		Badge badge = EventBadge.getBadgeByTotalBenefitsPrice(totalBenefitPrice).tobadge();

		return badge;
	}
}