package onboarding;

public class Problem4 {
	static final int ASCII_UPPERCASE = 155; // 아스키 코드 A+Z = 155
	static final int ASCII_LOWERCASE = 219; // 아스키 코드 a+z = 219

	public static String solution(String word) {
		String answer = "";

		for (char c : word.toCharArray()) {
			answer += convertAlphabet(c);
		}
		return answer;
	}

	private static boolean isAlphabet(char c) {
		return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
	}

	private static char convertAlphabet(char c) {
		if (!isAlphabet(c))
			return c;

		if (Character.isUpperCase(c))
			return (char)(ASCII_UPPERCASE - (int)c);

		return (char)(ASCII_LOWERCASE - (int)c);
	}
}
