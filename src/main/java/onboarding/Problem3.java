package onboarding;

public class Problem3 {

	public static final int EXCEPTION = -1;

	public static int solution(int number) {
		int cnt = 0;
		String strNumber = "";
		char oneLetter = ' ';

		if (checkRestrictions(number) == EXCEPTION) {
			return EXCEPTION;
		}

		for (int i = 1; i <= number; i++) {
			strNumber = String.valueOf(i); // int -> string 변환

			// 예를 들어, 36 이라는 숫자에는 박수 두 번
			for (int j = 0; j < strNumber.length(); j++) {
				oneLetter = strNumber.charAt(j);
				if (oneLetter == '3' || oneLetter == '6' || oneLetter == '9') {
					cnt++;
				}
			}
		}

		return cnt;
	}

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param number
	 * @return
	 */
	private static Integer checkRestrictions(int number) {
		if (!isNaturalNumber(number)) {
			return EXCEPTION;
		}
		return 0;
	}

	// number 가 자연수가 아닌 경우 예외
	private static boolean isNaturalNumber(int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}
}
