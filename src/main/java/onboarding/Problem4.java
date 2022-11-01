package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		answer = changeString(word);
		return answer;
	}

	public static char changeChar(char c) {
		if (c == ' ') {
			return ' ';
		}
		boolean isLowerCase = (c >= 'a');
		if (isLowerCase) {
			return (char)('a' + 'z' - c);
		}
		return (char)('A' + 'Z' - c);
	}

	public static String changeString(String word) {
		StringBuilder result = new StringBuilder();
		for (char c : word.toCharArray()) {
			result.append(changeChar(c));
		}
		return result.toString();
	}
}
