package onboarding;

public class Problem4 {
	private static final int upperNum = 155;
	private static final int lowerNum = 219;

	public static String solution(String word) {
		String answer = "";
		return answer;
	}

	private static char getReverse(char c) {
		if (!Character.isAlphabetic(c)) {
			return c;
		}
		if (Character.isUpperCase(c)) {
			return (char)(upperNum - c);
		}
		if (Character.isLowerCase(c)) {
			return (char)(lowerNum - c);
		}

		throw new IllegalArgumentException("잘못된 입력입니다");
	}
}
