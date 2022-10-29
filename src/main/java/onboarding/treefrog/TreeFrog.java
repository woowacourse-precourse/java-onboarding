package onboarding.treefrog;

public class TreeFrog {

	private static final int LOWER_CASE_FACTOR = 219; // 'a' + 'z'

	private static final int UPPER_CASE_FACTOR = 155; // 'A' + 'Z';

	/**
	 * Return translated alphabet based on formula
	 * @param ch alphabet to translate.
	 * <br>
	 * formula(ch) = BASE_ALPHABET + OFFSET(= 'Z/z' - ch)
	 * @return translated code
	 */
	public static char translateCode(final char ch) {
		if (Character.isLowerCase(ch)) {
			return (char)(LOWER_CASE_FACTOR - ch);
		}
		return (char)(UPPER_CASE_FACTOR - ch);
	}
}
