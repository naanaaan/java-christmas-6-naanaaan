package christmas.controller;

import christmas.domain.visitDate.VisitDate;
import christmas.service.visitDate.VisitDateService;

public class VisitDateController {

	private final VisitDateService visitDateService;

	public VisitDateController() {
		this.visitDateService = new VisitDateService();
	}

	public VisitDate getVisitDate(int day) {
		return visitDateService.createVisitDate(day);
	}
}