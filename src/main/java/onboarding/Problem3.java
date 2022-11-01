package onboarding;

public class Problem3 {
	private static final int min = 1;
	private static final int max = 10000;

	public static int solution(int number) {
		validate(number);
		int clapCount = 0;

		for (int i = 1; i <= number; i++) {
			clapCount += calculate369(i);
		}
		return clapCount;
	}

	private static int calculate369(int number) {
		String numAsString = String.valueOf(number);
		int cnt = 0;

		for (int i = 0; i < numAsString.length(); i++) {
			int num = numAsString.charAt(i) - '0';
			if (num == 3 || num == 6 || num == 9) {
				cnt++;
			}
		}
		return cnt;
	}

	private static void validate(int number) {
		if (number < min || number > max) {
			throw new IllegalArgumentException("숫자의 범위를 벗어났습니다.");
		}
	}
}
