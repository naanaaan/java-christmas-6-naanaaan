package christmas.domain.benefit;

import java.util.Collections;
import java.util.List;

public class Benefits {

	private final List<Benefit> benefits;

	public Benefits(List<Benefit> benefits) {
		this.benefits = filterNonZeroDiscountBenefits(benefits);
	}

	private List<Benefit> filterNonZeroDiscountBenefits(List<Benefit> benefits) {
		return benefits.stream(
				).filter(benefit -> benefit.checkNotZeroDiscountAmount())
				.toList();
	}
}