package onboarding;

public class Problem4 {

	private static final int UPPER = 65 + 90;
	private static final int LOWER = 97 + 122;

	public static String solution(String word) {
		String answer = "";
		char[] chars = word.toCharArray();

		for (char c : chars) {
			answer += decideWhatToAdd(c);
		}

		return answer;
	}

	private static String decideWhatToAdd(int ascii) {
		if (Character.isUpperCase(ascii)) {
			ascii = UPPER - ascii;
		} else if (Character.isLowerCase(ascii)) {
			ascii = LOWER - ascii;
		}
		return Character.toString(ascii);
	}
}
