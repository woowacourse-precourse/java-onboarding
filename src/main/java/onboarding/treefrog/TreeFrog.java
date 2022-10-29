package onboarding.treefrog;

public class TreeFrog {

	private static final int LOWER_CASE_FACTOR = 219; // 'a' + 'z'

	private static final int UPPER_CASE_FACTOR = 155; // 'A' + 'Z';

	private static final int ALPHABET_OFFSET = 32;

	/**
	 * Translate alphabet based on formula
	 * @param ch alphabet to translate.
	 * <br>
	 * formula(ch) = BASE_ALPHABET + ('Z/z' - ch) (+/-) 32
	 * @return translated code
	 */
	public static char translateCode(final char ch) {
		if (Character.isLowerCase(ch)) {
			return (char)(LOWER_CASE_FACTOR - ch - ALPHABET_OFFSET);
		}
		return (char)(UPPER_CASE_FACTOR - ch + ALPHABET_OFFSET);
	}
}
