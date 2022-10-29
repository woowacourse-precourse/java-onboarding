package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;

		try {
			isValidNumber(number);
		} catch (IllegalStateException illegalStateException) {
			illegalStateException.printStackTrace();
		}

		answer = countClaps(number);

		return answer;
	}

	public static void isValidNumber(int number) throws IllegalStateException {
		if (number < 1 || number > 10000)
			throw new IllegalStateException("number가 범위 밖입니다.");
	}

	public static int countClaps(int number) {
		return IntStream.range(1, number + 1).map(Problem3::getClapCounts).sum();
	}

	public static int getClapCounts(int number) {
		int clap = 0;
		int now = number;
		while (now > 0) {
			if (now % 10 != 0 && (now % 10) % 3 == 0) {
				clap++;
			}
			now /= 10;
		}
		return clap;
	}
}
