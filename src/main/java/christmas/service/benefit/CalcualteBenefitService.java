package christmas.service.benefit;

import java.util.List;

import christmas.domain.Benefit;

public class CalcualteBenefitService {
	
	public int calcualteBenefitDiscountAmountSum(List<Benefit> benefits) {
		return benefits.stream()
				.mapToInt(benefit -> benefit.discountAmount())
				.sum();
	}
}
