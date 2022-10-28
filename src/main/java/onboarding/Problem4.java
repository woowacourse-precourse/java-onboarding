package onboarding;

public class Problem4 {

	private static final int BLANK = 32;
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
		String answer = "";

		if (ascii == BLANK) {
			answer = " ";
		} else if (Character.isUpperCase(ascii)) {
			answer = Character.toString(UPPER - ascii);
		} else if (Character.isLowerCase(ascii)) {
			answer = Character.toString(LOWER - ascii);
		}

		return answer;
	}
}
