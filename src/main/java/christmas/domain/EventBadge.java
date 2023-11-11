package christmas.domain;

import java.util.Arrays;

public enum EventBadge {

	SANTA(20000, "산타"), 
	TREE(10000, "트리"), 
	STAR(5000, "별"), 
	NOTHING(0, "없음");

	private final int minTotalBenefitsAmount;
	private final String badgeName;

	EventBadge(int minTotalBenefitsAmount, String badgeName) {
		this.minTotalBenefitsAmount = minTotalBenefitsAmount;
		this.badgeName = badgeName;
	}

	public static EventBadge getBadgeByTotalBenefitsAmount(int totalBenefitsAmount) {
		return Arrays.stream(values())
				.filter(badge -> totalBenefitsAmount >= badge.minTotalBenefitsAmount)
				.findFirst()
				.orElse(NOTHING);
	}

	public Badge tobadge() {
		return new Badge(badgeName);
	}

	public String getBadgeName() {
		return badgeName;
	}
}
