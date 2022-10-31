package onboarding.problem3;

import java.util.Arrays;
import java.util.List;

public class Game369 {
	public static final List<String> GAME_TARGET = Arrays.asList("3", "6", "9");

	private static int countClap(String number) {
		int result = 0;

		String[] splitNumber = number.split("");
		for (String num : splitNumber) {
			if (GAME_TARGET.contains(num)) {
				result++;
			}
		}
		return result;
	}

	public static int start(int number) {
		int result = 0;
		for (int i = 1; i < number + 1; i++) {
			result += countClap(String.valueOf(i));
		}
		return result;
	}
}
