package onboarding.clapgame;

import java.util.Arrays;

public enum ClapUnit {
	THREE(3),
	SIX(6),
	NINE(9);

	private final int number;

	ClapUnit(int number) {
		this.number = number;
	}

	public static boolean isClapNumber(final int number) {
		return Arrays.stream(ClapUnit.values())
			.anyMatch(clapUnit -> clapUnit.number == number);
	}
}
