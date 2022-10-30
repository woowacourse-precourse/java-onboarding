package onboarding;

public class Problem4 {
	private static final int MIN_INPUT_LENGTH = 1;
	private static final int MAX_INPUT_LENGTH = 1000;

	public static String solution(String word) {
		if (!checkInputLength(word)) {
			throw new IllegalArgumentException();
		}
		StringBuilder answer = new StringBuilder();
		for (char ch : word.toCharArray()) {
			answer.append(converter(ch));
		}
		return answer.toString();
	}

	private static boolean checkInputLength(String input) {
		return input.length() >= MIN_INPUT_LENGTH && input.length() <= MAX_INPUT_LENGTH;
	}

	private static char converter(char alphabet) {
		if ('a' <= alphabet && 'z' >= alphabet) {
			return (char)('z' + 'a' - alphabet);
		}
		if ('A' <= alphabet && 'Z' >= alphabet) {
			return (char)('Z' + 'A' - alphabet);
		}
		return alphabet;
	}
}
