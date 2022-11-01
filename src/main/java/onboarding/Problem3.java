package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

	private static class ThreeSixNineGame {
		ThreeSixNineGame() {}

		public static int getCurrentTotal(int currentNumber,int currentUnit, int beforeUnitTotal, int preDigit) {
			return (currentNumber) * beforeUnitTotal + ((currentNumber - 1) / 3) * currentUnit + (currentNumber % 3 == 0 ? (preDigit + 1) : 0 );
		}
	}
}
