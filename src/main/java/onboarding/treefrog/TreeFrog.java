package onboarding.treefrog;

import java.util.stream.Collectors;

public class TreeFrog {

	private static final int LOWER_CASE_FACTOR = 219; // 'a' + 'z'

	private static final int UPPER_CASE_FACTOR = 155; // 'A' + 'Z';

	/**
	 * Translate alphabet based on formula
	 * @param ch alphabet to translate.
	 * <br>
	 * formula(ch) = BASE_ALPHABET + ('Z/z' - ch)
	 * @return translated code
	 */
	public static String translateCode(final char ch) {
		if (Character.isWhitespace(ch)) {
			return "" + ch;
		}
		if (Character.isLowerCase(ch)) {
			return "" + (char)(LOWER_CASE_FACTOR - ch);
		}
		return "" + (char)(UPPER_CASE_FACTOR - ch);
	}
}
