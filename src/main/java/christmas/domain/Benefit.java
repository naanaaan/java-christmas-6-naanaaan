package christmas.domain;

public record Benefit(Event event, int benefitAmount) {
	
	boolean checkNotZeroDiscountAmount() {
		return benefitAmount != 0;
	}
}