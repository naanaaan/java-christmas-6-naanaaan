package christmas.service.visitDate;

import christmas.domain.visitDate.VisitDate;

public class VisitDateService {

	public VisitDate createVisitDate(int day) {
		return new VisitDate(day);
	}
}
