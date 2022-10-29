package onboarding;

import java.util.stream.Stream;

public class Problem3 {
	public static int solution(int number) {
		if (!isValidNumber(number)) {
			return -1;
		}

		int answer = game(number);
		return answer;
	}

	private static boolean isValidNumber(int number) {
		return number >= 1 && number <= 1000;
	}

	private static int countClap(int number) {
		int result = 0;

		int[] numberList = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();

		for (int n : numberList) {
			if (n == 3 || n == 6 || n == 9) {
				result++;
			}
		}
		return result;
	}

	private static int game(int number) {
		int clap = 0;
		for (int i = 1; i <= number; i++) {
			clap += countClap(i);
		}
		return clap;
	}
}
