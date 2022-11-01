package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
	public static final char LOWER_SRC = 'a';
	public static final char LOWER_DEST = 'z';
	public static final char UPPER_SRC = 'A';
	public static final char UPPER_DEST = 'Z';

	public static final String ERROR_MESSAGE = "제한 사항을 위배했습니다.";
	public static final int EXCEPTION = -1;

	public static String solution(String word) {
		List<Character> words;
		if (checkRestrictions(word) == EXCEPTION) {
			return ERROR_MESSAGE;
		}

		words = conversionWord(word);
		return listToString(words);
	}

	private static String listToString(List<Character> words) {
		StringBuilder sb = new StringBuilder();
		for (Character letter : words) {
			sb.append(letter);
		}
		return sb.toString();
	}

	/**
	 * 주어진 문자열을 청개구리 사전대로 변환하는 메서드
	 * @param word
	 * @return
	 */
	private static List<Character> conversionWord(String word) {
		List<Character> letters = new ArrayList<>();
		char letter;
		for (int i = 0; i < word.length(); i++) {
			letter = word.charAt(i);
			if (letter > LOWER_SRC && letter < LOWER_DEST) {
				letter = (char)('a' + 'z' - letter);
			}
			if (letter > UPPER_SRC && letter < UPPER_DEST) {
				letter = (char)('A' + 'Z' - letter);
			}
			letters.add(letter);
		}
		return letters;
	}

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param word
	 * @return
	 */
	private static Integer checkRestrictions(String word) {
		if (!isNumberRangeValid(word)) {
			return EXCEPTION;
		}
		return 0;
	}

	// word 의 길이가 1 이상 1,000 이하가 아닌 경우 예외
	private static boolean isNumberRangeValid(String word) {
		if (word.length() < 1 || word.length() > 1000) {
			return false;
		}
		return true;
	}
}
