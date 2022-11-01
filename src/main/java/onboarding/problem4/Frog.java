package onboarding.problem4;

public class Frog {

	private static final Integer MAX_LENGTH = 1000;
	private static final Integer MIN_LENGTH = 1;

	private final char[] reversedLowerAlphabetArray;
	private final char[] reversedHigherAlphabetArray;

	public Frog() {
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

		if (word.length() < MIN_LENGTH || word.length() > MAX_LENGTH) {
			throw new RuntimeException("1 이상 1000 이하의 값만 입력 가능합니다.");
		}

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
		return (c >= 97) && (c <= 122);
	}

	private boolean isHigherAlphabet(char c) {
		return (c >= 65) && (c <= 90);
	}
}
