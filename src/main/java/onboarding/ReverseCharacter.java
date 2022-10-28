package onboarding;

public class ReverseCharacter {

	private static final int BLANK = 32;
	private static final int UPPER = 65 + 90;
	private static final int LOWER = 97 + 122;

	private final char[] chars;

	public ReverseCharacter(String word) {
		chars = word.toCharArray();
	}

	public String run() {
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
