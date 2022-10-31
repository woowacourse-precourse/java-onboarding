package onboarding;

public class Problem4 {
	public static String solution(String word) {
		return changeWord(word);
	}

	private static String changeWord(String word) {
		String answer = "";
		for (int i = 0; i < word.length(); i++) {
			answer = answer.concat(String.valueOf(changeLetter(word.charAt(i))));
		}
		return answer;
	}

	private static char changeLetter(char letter) {
		if (letter >= 'A' && letter <= 'Z') {
			return changeUpperCase(letter);
		}
		if (letter >= 'a' && letter <= 'z') {
			return changeLowerCase(letter);
		}
		return letter;
	}

	private static char changeUpperCase(char letter) {
		return (char)('A' + 'Z' - letter);
	}

	private static char changeLowerCase(char letter) {
		return (char)('a' + 'z' - letter);
	}
}
