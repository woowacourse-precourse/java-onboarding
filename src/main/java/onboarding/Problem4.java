package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		return answer;
	}

	static class Frog {

		private boolean isLowerAlphabet(char c) {
			return Character.isAlphabetic(c) && Character.isLowerCase(c);
		}

		private boolean isHigherAlphabet(char c) {
			return Character.isAlphabetic(c) && (!Character.isLowerCase(c));
		}
	}
}
