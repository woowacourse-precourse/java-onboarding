package onboarding.problem1;

public class MultiplyDigitToSum {
	private MultiplyDigitToSum() {
	}

	public static int calculate(int n) {
		int answer = 1;
		while (n > 0 && answer != 0) {
			answer *= n % 10;
			n /= 10;
		}
		return answer;
	}
}
