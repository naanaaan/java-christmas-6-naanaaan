package christmas.domain.benefit;

public record Benefit(DecemberEvent event, int benefitAmount) {

	public boolean isNotZeroBenefitAmount() {
		return benefitAmount != 0;
	}

	public boolean isNotGiveawayEventBenefit() {
		return event != DecemberEvent.GIVEAWAY_EVENT;
	}
}