package onboarding;

public class Problem4 {
	public static String solution(String word) {
		StringBuilder answer = new StringBuilder();
		for (char c : word.toCharArray()) {
			answer.append(convertFrogWord(c));
		}
		return answer.toString();
	}

	private static char convertFrogWord(char c) {
		if (Character.isLowerCase(c)) {
			return (char)('a' + ('z' - c));
		} else if (Character.isUpperCase(c)) {
			return (char)('A' + ('Z' - c));
		}
		return c;
	}
}
