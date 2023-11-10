package christmas.service.crate;

import christmas.domain.VisitDate;

public class CreateVisitDateService {

	public VisitDate createVisitDate(int day) {
		return new VisitDate(day);
	}
}
