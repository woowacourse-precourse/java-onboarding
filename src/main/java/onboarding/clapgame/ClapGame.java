package onboarding.clapgame;

import java.util.stream.IntStream;

public class ClapGame {

	public static boolean isClappedWith(final int number) {
		return convertDigitsOf(number)
			.anyMatch(ClapGame::isMultipleOfThree);
	}

	private static IntStream convertDigitsOf(int number) {
		return String.valueOf(number)
			.chars()
			.map(ch -> ch - 48);
	}

	private static boolean isMultipleOfThree(final int number) {
		return number != 0 && number % 3 == 0;
	}

	public static long getClapCountOf(final int number) {
		return convertDigitsOf(number)
			.filter(ClapGame::isMultipleOfThree)
			.count();
	}

	public static int getTotalClapCountOf(final int number) {
		int clapCount = 0;
		for (int n = 3; n <= number; n++) {
			clapCount += getClapCountOf(n);
		}
		return clapCount;
	}
}
