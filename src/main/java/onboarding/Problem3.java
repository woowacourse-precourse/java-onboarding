package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;

		try {
			isValidNumber(number);
		} catch (IllegalStateException illegalStateException) {
			illegalStateException.printStackTrace();
		}

		return answer;
	}

	public static void isValidNumber(int number) throws IllegalStateException {
		if (number < 1 || number > 10000)
			throw new IllegalStateException("number가 범위 밖입니다.");
	}
}
