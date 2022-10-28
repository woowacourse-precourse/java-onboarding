package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		return answer;
	}

	static class InputValidator {
		private static boolean isRightWordRange(String word) {
			int wordLength = word.length();
			if (wordLength < 1 && wordLength > 1000) {
				return false;
			}
			return true;
		}
	}
}
