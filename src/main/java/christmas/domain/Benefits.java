package christmas.domain;

import java.util.List;

public class Benefits {

	private final List<Benefit> benefits;

	public Benefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}

	public List<Benefit> getNotZeroDiscountPrice() {
		return benefits.stream()
				.filter(benefit -> benefit.discountPrice() != 0)
				.toList();
	}
}