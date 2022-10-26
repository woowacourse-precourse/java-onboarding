package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		for (char ch : word.toCharArray()) {
			answer += converter(ch);
		}
		return answer;
	}

	private static char converter(char alphabet) {
		if ('a' <= alphabet && 'z' >= alphabet) {
			alphabet = (char)('z' + 'a' - alphabet);
		} else if ('A' <= alphabet && 'Z' >= alphabet) {
			alphabet = (char)('Z' + 'A' - alphabet);
		} else {
			return alphabet;
		}
		return alphabet;
	}
}
