package christmas.domain.badge;

import java.util.Arrays;
import java.util.Optional;

public enum EventBadge {

	SANTA(20_000, "산타"),
	TREE(10_000, "트리"),
	STAR(5_000, "별");

	private final int minTotalBenefitAmount;
	private final String badgeName;

	EventBadge(int minTotalBenefitAmount, String badgeName) {
		this.minTotalBenefitAmount = minTotalBenefitAmount;
		this.badgeName = badgeName;
	}

	public static Optional<EventBadge> getBadgeByTotalBenefitAmount(int totalBenefitAmount) {
		return Arrays.stream(values())
				.filter(badge -> totalBenefitAmount >= badge.minTotalBenefitAmount)
				.findFirst();
	}

	public Badge toBadge() {
		return new Badge(badgeName);
	}
}