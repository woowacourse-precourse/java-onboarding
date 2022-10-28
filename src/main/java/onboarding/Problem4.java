package onboarding;

public class Problem4 {
	private static final int A_UPPER_ASCII = 65;
	private static final int Z_UPPER_ASCII = 90;
	private static final int A_LOWER_ASCII = 97;
	private static final int Z_LOWER_ASCII = 122;

	public static String solution(String word) {
		String answer = "";
		answer = getTreeFrogLanguage(word);
		return answer;
	}

	private static String getTreeFrogLanguage(String word) {
		String treeFrogLanguage = "";
		if (!InputValidator.isRightWordRange(word)) {
			throw new IllegalArgumentException();
		}
		for (char c : word.toCharArray()) {
			treeFrogLanguage += changeValueFromTreeFrogDict(c);
		}
		return treeFrogLanguage;
	}

	public static char changeValueFromTreeFrogDict(char c) {
		if (isAlpha(c)) {
			return getValueFromTreeFrogDict(c);
		}
		return c;
	}

	public static char getValueFromTreeFrogDict(char c) {
		int key = charToAscii(c);
		if (Character.isUpperCase(c)) {
			return (char)(Z_UPPER_ASCII - (key - A_UPPER_ASCII));
		} else if (Character.isLowerCase(c)) {
			return (char)(Z_LOWER_ASCII - (key - A_LOWER_ASCII));
		}
		return ' ';
	}

	private static int charToAscii(char c) {
		return (int)c;
	}

	public static boolean isAlpha(char c) {
		if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
			return false;
		}
		return true;
	}

	static class InputValidator {
		private static boolean isRightWordRange(String word) {
			int wordLength = word.length();
			if (wordLength < 1 || wordLength > 1000) {
				return false;
			}
			return true;
		}
	}
}
