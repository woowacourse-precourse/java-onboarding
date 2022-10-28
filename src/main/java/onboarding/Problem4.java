package onboarding;

public class Problem4 {

	public static final int LOWER = 219;
	public static final int UPPER = 155;

	public static StringBuilder sb = new StringBuilder();

	public static String solution(String word) {
		treeFrogDictionary(word);
		return sb.toString();
	}

	public static void treeFrogDictionary(String word) {
		for (int i = 0; i < word.length(); i++) {
			sb.append(isAlpha(word.charAt(i)));
		}
	}

	public static char isAlpha(char c) {
		
		return c;
	}

	public static char translateLower(int c) {
		return (char)(LOWER - c);
	}

	public static char translateUpper(int c) {
		return (char)(UPPER - c);
	}
}
