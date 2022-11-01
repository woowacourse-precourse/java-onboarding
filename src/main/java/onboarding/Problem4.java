package onboarding;

public class Problem4 {
	static final char LEFT_BOUND_OF_UPPER_CASE = 'A';
	static final char RIGHT_BOUND_OF_UPPER_CASE = 'Z';
	static final char LEFT_BOUND_OF_LOWER_CASE = 'a';
	static final char RIGHT_BOUND_OF_LOWER_CASE = 'z';

	public static String solution(String word) {
		return changeWord(word);
	}

	private static String changeWord(String word) {
		StringBuilder answer = new StringBuilder();
		for (int index = 0; index < word.length(); index++) {
			answer.append(changeLetter(word.charAt(index)));
		}
		return answer.toString();
	}

	private static char changeLetter(char letter) {
		if (letter >= LEFT_BOUND_OF_UPPER_CASE && letter <= RIGHT_BOUND_OF_UPPER_CASE) {
			return changeUpperCase(letter);
		}
		if (letter >= LEFT_BOUND_OF_LOWER_CASE && letter <= RIGHT_BOUND_OF_LOWER_CASE) {
			return changeLowerCase(letter);
		}
		return letter;
	}

	private static char changeUpperCase(char letter) {
		return (char)(LEFT_BOUND_OF_UPPER_CASE + RIGHT_BOUND_OF_UPPER_CASE - letter);
	}

	private static char changeLowerCase(char letter) {
		return (char)(LEFT_BOUND_OF_LOWER_CASE + RIGHT_BOUND_OF_LOWER_CASE - letter);
	}
}
