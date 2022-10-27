package onboarding.problem1;

public class AddEachDigitToSum {
	private AddEachDigitToSum() {
	}

	public static int calculate(int n) {
		int answer = 0;
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		return answer;
	}
}
