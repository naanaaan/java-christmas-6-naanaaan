package christmas.service;

import christmas.domain.VisitDate;

public class CreateService {

	public VisitDate createVisitDate(int day) {
		return new VisitDate(day);
	}
}