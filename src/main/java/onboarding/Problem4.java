package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
	private static final String EXCEPTION_MESSAGE = "ERROR";
	private static Map<Character, Character> dictionary = new HashMap<>();
    public static String solution(String word) {
		if (!isValidLength(word.length())) {
			return getExceptionMessage();
		}

		initDictionary();

        return answer;
    }

	private static boolean isValidLength(int length) {
		return length >= 1 && length <= 1000;
	}

	private static String getExceptionMessage() {
		return EXCEPTION_MESSAGE;
	}

	private static void initDictionary() {
		for (int i = 0; i < 26; i++) {
			dictionary.put((char)('A' + i), (char)('A' + 25 - i));
			dictionary.put((char)('a' + i), (char)('a' + 25 - i));
		}
	}

}
