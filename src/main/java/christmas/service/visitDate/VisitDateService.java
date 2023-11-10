package christmas.service.visitDate;

import christmas.domain.VisitDate;

public class VisitDateService {

	public VisitDate createVisitDate(int day) {
		return new VisitDate(day);
	}
}
