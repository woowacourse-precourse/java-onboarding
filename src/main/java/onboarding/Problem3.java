package onboarding;

import java.util.Arrays;

public class Problem3 {
	private static final String NUMBER_OF_DIGIT_DIVISION = "";
	private static final String CLAP_NUMBER_REGEX = "[369]";
	private static final int MIN_INPUT_NUMBER = 1;
	private static final int MAX_INPUT_NUMBER = 10000;

	public static int solution(int number) {
		if (!isInputRange(number)) {
			throw new IllegalArgumentException();
		}
		int clapCount = 0;
		for (int i = 0; i <= number; i++) {
			clapCount += isClap(String.valueOf(i));
		}
		return clapCount;
	}

	private static boolean isInputRange(int number) {
		return number >= MIN_INPUT_NUMBER && number <= MAX_INPUT_NUMBER;
	}

	private static int isClap(String number) {
		return (int)Arrays.stream(number.split(NUMBER_OF_DIGIT_DIVISION))
			.filter(digit -> digit.matches(CLAP_NUMBER_REGEX))
			.count();
	}

}
