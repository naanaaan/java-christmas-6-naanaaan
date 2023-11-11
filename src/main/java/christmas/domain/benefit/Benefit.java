package christmas.domain.benefit;

public record Benefit(DecemberEvent event, int benefitAmount) {
	
	boolean checkNotZeroDiscountAmount() {
		return benefitAmount != 0;
	}
}