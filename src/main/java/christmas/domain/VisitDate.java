package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {

	private static int YEAR = 2023;
	private static int MONTH = 12;
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
		if (day > MAX_DAY || day < MIN_DAY) {
			throw new IllegalArgumentException();
		}
	}

	public boolean checkWeekend() {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
			return true;
		}

		return false;
	}
}