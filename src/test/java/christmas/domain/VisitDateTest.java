package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateTest {

	@DisplayName("방문날짜가 해당 월의 최대 일을 초과할 때 예외가 발생한다.")
	@ValueSource(ints = { 32, 34, 36 })
	@ParameterizedTest
	void createVisitDateByOverRange(int day) {
		assertThatThrownBy(() -> new VisitDate(day))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("방문날짜가 해당 월의 일에 해당될 때 정상작동한다.")
	@ValueSource(ints = { 1, 24, 31 })
	@ParameterizedTest
	void checkNomalOperation1(int day) {
		assertDoesNotThrow(() -> new VisitDate(day));
	}

	@ParameterizedTest
	@CsvSource(value = { "1, true", "5, false", "21, 17", "30, true", }, delimiter = ',')
    void checkWeekend(int day, boolean expect) {
        VisitDate visitDate = new VisitDate(day);
        boolean result = visitDate.checkWeekend();
        assertEquals(expect, result);
    }
}