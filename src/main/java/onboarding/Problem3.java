package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int count = 0;

		for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
			count += calculateClapCount(currentNumber);
		}

		return count;
	}

	private static int calculateClapCount(int current) {
		int clapCount = 0;

		while (isCurrentOverZero(current)) {
			if (isLastDigitThree(current) || isLastDigitSix(current) || isLastDigitNine(current)) {
				clapCount++;
			}
			current = reduceNumberOfDigit(current);
		}
		return clapCount;
	}

	private static boolean isCurrentOverZero(int current) {
		return current > 0;
	}

	private static boolean isLastDigitThree(int current) {
		return current % 10 == 3;
	}

	private static boolean isLastDigitSix(int current) {
		return current % 10 == 6;
	}

	private static boolean isLastDigitNine(int current) {
		return current % 10 == 9;
	}

	private static int reduceNumberOfDigit(int current) {
		return current / 10;
	}
}
