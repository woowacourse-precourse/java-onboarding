package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	private static int clap;

	public static int solution(int number) {
		clap = 0;
		for (int i = 1; i < number + 1; i++) {
			List<Integer> digits = splitByDigit(i);
			countClap(digits);
		}
		return clap;
	}

	private static List<Integer> splitByDigit(int number) {
		List<Integer> digits = new ArrayList<>();
		while (number > 0) {
			digits.add(number % 10);
			number /= 10;
		}
		return digits;
	}

	private static void countClap(List<Integer> digits) {
		for (Integer digit : digits) {
			if (is369(digit)) {
				clap += 1;
			}
		}
	}

	private static boolean is369(int number) {
		return number == 3 || number == 6 || number == 9;
	}
}
