package onboarding.problem1;

public class PageMultiplyCalculator {

	private final int TEN = 10;

	public int calculate(int page) {
		int answer = 1;
		while (page > 0) {
			answer *= page % TEN;
			page /= TEN;
		}
		return answer;
	}
}
