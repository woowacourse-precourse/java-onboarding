package onboarding;

import java.util.Arrays;

public class Problem3 {
	private static final String NUMBER_OF_DIGIT_DIVISION = "";
	private static final String CLAP_NUMBER_REGEX = "[369]";

	public static int solution(int number) {
		int clapCount = 0;
		for (int i = 0; i <= number; i++) {
			clapCount += isClap(String.valueOf(i));
		}
		return clapCount;
	}

	private static int isClap(String number) {
		return (int)Arrays.stream(number.split(NUMBER_OF_DIGIT_DIVISION))
			.filter(digit -> digit.matches(CLAP_NUMBER_REGEX))
			.count();
	}
}
