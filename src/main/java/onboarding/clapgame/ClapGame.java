package onboarding.clapgame;

import java.util.stream.IntStream;

public class ClapGame {

	public static long getClapCount(final int number) {
		return IntStream.range(3, number+1)
			.mapToLong(ClapGame::countClapCount)
			.sum();
	}

	static long countClapCount(final int number) {
		return getDigitStream(number)
			.filter(ClapUnit::isClapNumber)
			.count();
	}

	private static IntStream getDigitStream(final int number) {
		return String.valueOf(number)
			.chars()
			.map(Character::getNumericValue);
	}
}
