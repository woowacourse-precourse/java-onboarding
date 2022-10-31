package onboarding.clapgame;

import java.util.stream.IntStream;

public class ClapGame {

	public static int getClapCountUntil(final int number) {
		int clapCount = 0;
		for (int n = 3; n <= number; n++) {
			clapCount += getClapCount(n);
		}
		return clapCount;
	}

	static long getClapCount(final int number) {
		return getDigitStream(number)
			.filter(ClapGame::isMultipleOfThree)
			.count();
	}

	private static IntStream getDigitStream(final int number) {
		return String.valueOf(number)
			.chars()
			.map(Character::getNumericValue);
	}

	static boolean isMultipleOfThree(final int number) {
		return number != 0 && number % 3 == 0;
	}
}
