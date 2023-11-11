package christmas.controller;

import java.util.Optional;

import christmas.domain.EventBadge;
import christmas.service.badge.BadgeService;

public class BadgeController {

	private final BadgeService badgeService;

	public BadgeController() {
		this.badgeService = new BadgeService();
	}

	public Optional<EventBadge> getBadge(int totalBenefitsAmount) {
		return badgeService.getBadgeByTotalBenefitsAmount(totalBenefitsAmount);
	}
}
