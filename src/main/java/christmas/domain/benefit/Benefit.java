package christmas.domain.benefit;

public record Benefit(DecemberEvent event, int benefitAmount) {

	public boolean checkNotZeroDiscountAmount() {
		return benefitAmount != 0;
	}

	public boolean isGiveawayEventBenefit() {
		return event == DecemberEvent.GIVEAWAY_EVENT;
	}
}