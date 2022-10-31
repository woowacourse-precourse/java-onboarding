package onboarding.problem1;

public class PagePlusCalculator {

	private static final int TEN = 10;

	public int calculate(int page) {
		int answer = 0;
		while (page > 0) {
			answer += page % TEN;
			page = page / TEN;
		}
		return answer;
	}
}
