package christmas.domain.benefit;

import java.util.List;

public class Benefits {

	private final List<Benefit> benefits;

	public Benefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}

	public List<Benefit> getNotZeroDiscountAmount() {
		return benefits.stream()
				.filter(benefit -> benefit.checkNotZeroDiscountAmount())
				.toList();
	}
}