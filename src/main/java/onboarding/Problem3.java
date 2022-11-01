package onboarding;

public class Problem3 {

	public static final int EXCEPTION = -1;

	public static int solution(int number) {
		int cnt = 0;
		String numberToString = "";
		char letter = ' ';

		if (checkRestrictions(number) == EXCEPTION) {
			return EXCEPTION;
		}

		for (int i = 1; i <= number; i++) {
			numberToString = String.valueOf(i);
			for (int j = 0; j < numberToString.length(); j++) {
				letter = numberToString.charAt(j);
				if (letter == '3' || letter == '6' || letter == '9') {
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static Integer checkRestrictions(int number) {
		if (!isNumberRangeValid(number)) {
			return EXCEPTION;
		}
		return 0;
	}

	private static boolean isNumberRangeValid(int number) {
		if (number < 1 || number > 10000) {
			return false;
		}
		return true;
	}
}
