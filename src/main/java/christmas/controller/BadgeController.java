package christmas.controller;

import java.util.Optional;

import christmas.domain.badge.EventBadge;
import christmas.service.badge.BadgeService;

public class BadgeController {

	private final BadgeService badgeService;

	public BadgeController() {
		this.badgeService = new BadgeService();
	}

	public Optional<EventBadge> getBadge(int totalBenefitAmount) {
		return badgeService.getBadgeByTotalBenefitAmount(totalBenefitAmount);
	}
}
