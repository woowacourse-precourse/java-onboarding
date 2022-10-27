package onboarding.problem1;

import java.util.Arrays;

public class PageNumberGame {
	public static final Integer POBI_WIN = 1;
	public static final Integer CRONG_WIN = 2;
	public static final Integer TIE_MATCH = 0;
	public static final Integer EXCEPTION = -1;

	private static Integer addEachNumber(Integer number) {
		return Arrays.stream(number.toString().split(""))
			.mapToInt(Integer::parseInt)
			.sum();
	}
	
}
