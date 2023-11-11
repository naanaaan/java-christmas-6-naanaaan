package christmas.domain;

import java.util.Arrays;

public enum EventBadge {

	SANTA(20000, "산타"), 
	TREE(10000, "트리"), 
	STAR(5000, "별"), 
	NOTHING(0, "없음");

	private final int minTotalBenefitsPrice;
	private final String badgeName;

	EventBadge(int minTotalBenefitsPrice, String badgeName) {
		this.minTotalBenefitsPrice = minTotalBenefitsPrice;
		this.badgeName = badgeName;
	}

	public static EventBadge getBadgeByTotalBenefitsPrice(int totalBenefitsPrice) {
		return Arrays.stream(values())	
				.filter(badge -> Math.abs(totalBenefitsPrice) >= badge.minTotalBenefitsPrice)
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
