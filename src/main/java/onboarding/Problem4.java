package onboarding;

public class Problem4 {
	public static String solution(String word) {
		char[] chars = word.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			chars[i] = convertAlphabet(chars[i]);
		}
		return String.valueOf(chars);
	}

	public static char convertAlphabet(char alphabet) {
		if (alphabet >= 'A' && alphabet <= 'Z') {
			return (char) ('Z' - (alphabet - 'A'));
		}
		if (alphabet >= 'a' && alphabet <= 'z') {
			return (char) ('z' - (alphabet - 'a'));
		}
		return alphabet;
	}
}
