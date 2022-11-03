package onboarding.treefrog;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Translate alphabet based on formula.
 * <br>
 * formula(character) = LETTER_CASE_FACTOR - character
 */
public enum AlphabetTranslator {
	UPPER_CASE('A' + 'Z', 2),
	LOWER_CASE('a' + 'z', 1);

	private final int factor;

	private final int letterType;

	AlphabetTranslator(int factor, int charType) {
		this.factor = factor;
		this.letterType = charType;
	}

	private Function<Character, String> getFormula() {
		return (Character c)
			-> String.valueOf((char)(getFactor() - c));
	}

	public int getFactor() {
		return factor;
	}

	public static boolean isValidType(final int letterType) {
		return Arrays.stream(AlphabetTranslator.values())
			.anyMatch(alphabetTranslator -> alphabetTranslator.letterType == letterType);
	}

	public String translate(final char ch) {
		return getFormula().apply(ch);
	}
}
