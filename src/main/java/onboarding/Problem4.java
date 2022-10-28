package onboarding;

public class Problem4 {
	public static String solution(String word) {
		Frog frog = new Frog();
		return frog.translate(word);
	}

	static class Frog {

		private final char[] reversedLowerAlphabetArray;
		private final char[] reversedHigherAlphabetArray;

		Frog() {
			char[] reversedLowerAlphabetArray = new char[26];
			char[] reversedHigherAlphabetArray = new char[26];

			for (int i = 0; i < 26; i++) {
				reversedLowerAlphabetArray[i] = (char)(122 - i);
				reversedHigherAlphabetArray[i] = (char)(90 - i);
			}
			this.reversedLowerAlphabetArray = reversedLowerAlphabetArray;
			this.reversedHigherAlphabetArray = reversedHigherAlphabetArray;
		}

		public String translate(String word) {
			StringBuilder stringBuilder = new StringBuilder();
			for(char c : word.toCharArray()) {
				stringBuilder.append(reverse(c));
			}
			return stringBuilder.toString();
		}

		private char reverse(char c) {
			if (isLowerAlphabet(c)) {
				int index = c - 97;
				return reversedLowerAlphabetArray[index];
			} else if (isHigherAlphabet(c)) {
				int index = c - 65;
				return reversedHigherAlphabetArray[index];
			}
			return c;
		}

		private boolean isLowerAlphabet(char c) {
			return Character.isAlphabetic(c) && Character.isLowerCase(c);
		}

		private boolean isHigherAlphabet(char c) {
			return Character.isAlphabetic(c) && (!Character.isLowerCase(c));
		}
	}
}
