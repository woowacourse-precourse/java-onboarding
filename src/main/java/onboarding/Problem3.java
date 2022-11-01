package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

	private static class ThreeSixNineGame {
		private final static int DEFAULT_DIGIT_UNIT = 1;
		private final static int DEFAULT_MAXIMUM_CLAPPING = 0;
		private final static int UNIT_CONVERT_CRITERIA = 10;
		private final static int COMMON_CLAP_CYCLE = 3;
		private final static int COUNT_FROM_ZERO = 1;
		private int currentDigitUnit;
		private int previousUnitMaxClap;

		ThreeSixNineGame() {
			this.currentDigitUnit = DEFAULT_DIGIT_UNIT;
			this.previousUnitMaxClap = DEFAULT_MAXIMUM_CLAPPING;
		}

		int getTotalClap(int number) {
			int currentDigit;
			int previousNumberSum = 0;
			int totalClaps = 0;

			while (number > 0) {
				currentDigit = number % 10;
				totalClaps += getNumberOfClap(currentDigit, previousNumberSum);
				previousUnitMaxClap += getCurrentTotal(9, currentDigitUnit, previousUnitMaxClap, currentDigitUnit - 1);
				previousNumberSum += currentDigit * currentDigitUnit;
				number /= UNIT_CONVERT_CRITERIA;
				currentDigitUnit *= UNIT_CONVERT_CRITERIA;
			}

			return totalClaps;
		}

		private int getFilledCaseClap(int number) {
			return (number * previousUnitMaxClap) + ((number - 1) / COMMON_CLAP_CYCLE) * currentDigitUnit;
		}

		public static int getCurrentTotal(int currentNumber,int currentUnit, int beforeUnitTotal, int preDigit) {
			return (currentNumber) * beforeUnitTotal + ((currentNumber - 1) / 3) * currentUnit + (currentNumber % 3 == 0 ? (preDigit + 1) : 0 );
		}

		private boolean isUnfilledCaseHasClap(int number) {
			return number % COMMON_CLAP_CYCLE == 0;
		}

		private int getNumberOfClap(int number, int previousNumberSum) {
			int clapping = getFilledCaseClap(number);
			if (isUnfilledCaseHasClap(number)) {
				clapping += previousNumberSum + COUNT_FROM_ZERO;
			}
			return clapping;
		}
	}
}
