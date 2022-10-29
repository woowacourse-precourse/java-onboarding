package onboarding.clapgame;

public class ClapGame {

	public static boolean isClappedWith(final int number) {
		return String.valueOf(number)
			.chars()
			.map(digit -> digit - 48)
			.anyMatch(ClapGame::isMultipleOfThree);
	}

	private static boolean isMultipleOfThree(final int number) {
		return number != 0 && number % 3 == 0;
	}
}
