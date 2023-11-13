package christmas.controller;

import christmas.domain.badge.Badge;
import christmas.service.badge.BadgeService;

public class BadgeController {

	private final BadgeService badgeService;

	public BadgeController() {
		this.badgeService = new BadgeService();
	}

	public Badge getBadge(int totalBenefitAmount) {
		return badgeService.createBadgeByTotalBenefitAmount(totalBenefitAmount);
	}
}