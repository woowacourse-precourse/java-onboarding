package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		return answer;
	}

	private static int countOneNumber(int number) {
		int count = 0;
		while (number > 0) {
			count += check369InNumber(number % 10);
			number /= 10;
		}
		return count;
	}

	private static int check369InNumber(int number) {
		if (number != 0 && number % 3 == 0) {
			return 1;
		}
		return 0;
	}

	static class InputValidator {
		private static boolean isRightNumberRange(int number) {
			if (number < 1 || number > 10000) {
				return false;
			}
			return true;
		}
	}
}
