package onboarding.treefrog;

import java.util.stream.Collectors;

public class TreeFrog {

	static String translateCode(final char ch) {
		if (isNotAlphabetic(ch)) {
			return String.valueOf(ch);
		}
		AlphabetTranslator alphabetTranslator = Character.isLowerCase(ch)
			? AlphabetTranslator.LOWER_CASE
			: AlphabetTranslator.UPPER_CASE;

		return alphabetTranslator.translate(ch);
	}

	private static boolean isNotAlphabetic(char ch) {
		int letterType = Character.getType(ch);
		return !AlphabetTranslator.isValidType(letterType);
	}

	public static String translate(final String word) {
		return word.chars()
			.mapToObj(ch -> translateCode((char)ch))
			.collect(Collectors.joining());
	}
}
