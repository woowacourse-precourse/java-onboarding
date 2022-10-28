package onboarding;

public class Problem4 {

	private static final int BLANK = 32;
	private static final int UPPER = 65 + 90;
	private static final int LOWER = 97 + 122;

	public static String solution(String word) {
		char[] chars = word.toCharArray();

		String answer = "";

		for (char c : chars) {
			int ascii = (int)c;

			if (ascii == BLANK) {
				answer += " ";
			} else if (Character.isUpperCase(ascii)) {
				answer += Character.toString(UPPER - ascii);
			} else if (Character.isLowerCase(ascii)) {
				answer += Character.toString(LOWER - ascii);
			}

		}
		return answer;
	}
}
