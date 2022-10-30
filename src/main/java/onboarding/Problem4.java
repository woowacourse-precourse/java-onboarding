package onboarding;

public class Problem4 {
	public static String solution(String word) {
		StringBuilder answer = new StringBuilder();
		for (char ch : word.toCharArray()) {
			answer.append(converter(ch));
		}
		return answer.toString();
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
