package christmas.service.benefit;

import java.util.Arrays;

public class CalculateSumService {

	public int calculateSum(Integer... integers) {
		if (integers == null || integers.length == 0) {
			return 0;
		}

		return Arrays.stream(integers)
				.mapToInt(Integer::intValue)
				.sum();
	}
}