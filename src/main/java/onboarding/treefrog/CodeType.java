package onboarding.treefrog;

import java.util.function.Function;

/**
 * Translate alphabet based on formula.
 * <br>
 * formula(character) = LETTER_CASE_FACTOR - character
 */
public enum CodeType {
	UPPER_CASE('A' + 'Z'),
	LOWER_CASE('a' + 'z');

	private final int factor;

	CodeType(int factor) {
		this.factor = factor;
	}

	private Function<Character, String> getFormula() {
		return (Character c)
			-> String.valueOf((char)(getFactor() - c));
	}

	public int getFactor() {
		return factor;
	}

	public String translate(final char ch) {
		return getFormula().apply(ch);
	}
}
