package christmas.domain.visitDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

import christmas.util.ErrorMessage;

public class VisitDate {

	private static int YEAR = 2023;
	public static int MONTH = 12;
	private static int MIN_DAY = 1;
	private static int MAX_DAY = LocalDate.of(YEAR, MONTH, 1).lengthOfMonth();

	private final LocalDate date;

	public VisitDate(int day) {
		validate(day);
		this.date = LocalDate.of(YEAR, MONTH, day);
	}

	private void validate(int day) {
		validateisOutOfRange(day);
	}

	private void validateisOutOfRange(int day) {
		if (isOutOfRange(day)) {
			throw new IllegalArgumentException(ErrorMessage.VALID_VISITDATE.getMessage());
		}
	}

	private boolean isOutOfRange(int day) {
		return day > MAX_DAY || day < MIN_DAY;
	}

	public boolean isWeekend() {
		DayOfWeek visitDateOfWeek = date.getDayOfWeek();

		return checkWeekend(visitDateOfWeek);
	}

	private boolean checkWeekend(DayOfWeek visitDateOfWeek) {
		return visitDateOfWeek == DayOfWeek.FRIDAY || visitDateOfWeek == DayOfWeek.SATURDAY;
	}

	public int getDay() {
		return date.getDayOfMonth();
	}
}