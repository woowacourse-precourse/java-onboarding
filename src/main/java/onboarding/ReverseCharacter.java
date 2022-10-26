package onboarding;

public class ReverseCharacter {

	private static final int BLANK = 32;
	private static final int UPPER = 65 + 90;

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
			}

		}
		return answer;
	}
}
