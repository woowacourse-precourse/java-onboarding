package onboarding.treefrog;

import java.util.stream.Collectors;

public class TreeFrog {

	static String translateCode(final char ch) {
		if (isNotAlphabetic(ch)) {
			return String.valueOf(ch);
		}
		CodeType codeType = Character.isLowerCase(ch)
			? CodeType.LOWER_CASE
			: CodeType.UPPER_CASE;

		return codeType.translate(ch);
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
