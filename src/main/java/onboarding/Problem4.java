package onboarding;

import java.util.HashMap;

public class Problem4 {

	private static final HashMap<Character, Character> replaceList = new HashMap<>();

	public static String solution(String word) {
		initialReplaceList();

		return replaceWord(word);
	}

	private static String replaceWord(String word) {
		StringBuilder result = new StringBuilder();
		for (char c : word.toCharArray()) {
			result.append(replaceList.getOrDefault(c, c));
		}
		return result.toString();
	}

	private static void initialReplaceList() {
		for (char i = 'a'; i <= 'z'; i++) {
			char value = (char)('z' - (i - 'a'));
			replaceList.put(i, value);
		}

		for (char i = 'A'; i <= 'Z'; i++) {
			char value = (char)('Z' - (i - 'A'));
			replaceList.put(i, value);
		}
	}
}
