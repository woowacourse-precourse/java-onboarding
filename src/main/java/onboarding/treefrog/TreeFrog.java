package onboarding.treefrog;

import java.util.stream.Collectors;

public class TreeFrog {

	private static final int LOWER_CASE_FACTOR = 219; // 'a' + 'z'

	private static final int UPPER_CASE_FACTOR = 155; // 'A' + 'Z';

	/**
	 * Translate alphabet based on formula
	 * @param ch alphabet to translate.
	 * <br>
	 * formula(character) = LETTER_CASE_FACTOR - character
	 * @return translated code
	 */
	public static String translateCode(final char ch) {
		if (isNotAlphabetic(ch)) {
			return String.valueOf(ch);
		}
		int factor = UPPER_CASE_FACTOR;

		if (Character.isLowerCase(ch)) {
			return "" + (char)(LOWER_CASE_FACTOR - ch);
		}
		return String.valueOf((char)(factor - ch));
	}

	private static boolean isNotAlphabetic(char ch) {
		return Character.isWhitespace(ch)
			|| !Character.isAlphabetic(ch);
	}

	public static String translate(final String word) {
		return word.chars()
			.mapToObj(ch -> translateCode((char)ch))
			.collect(Collectors.joining());
	}
}
