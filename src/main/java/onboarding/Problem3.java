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
				totalClaps += getCurrentTotal(currentDigit, currentDigitUnit, previousUnitMaxClap, previousNumberSum);
				previousUnitMaxClap += getCurrentTotal(9, currentDigitUnit, previousUnitMaxClap, currentDigitUnit - 1);
				previousNumberSum += currentDigit * currentDigitUnit;
				number /= UNIT_CONVERT_CRITERIA;
				currentDigitUnit *= UNIT_CONVERT_CRITERIA;
			}

			return totalClaps;
		}

		public static int getCurrentTotal(int currentNumber,int currentUnit, int beforeUnitTotal, int preDigit) {
			return (currentNumber) * beforeUnitTotal + ((currentNumber - 1) / 3) * currentUnit + (currentNumber % 3 == 0 ? (preDigit + 1) : 0 );
		}
	}
}
