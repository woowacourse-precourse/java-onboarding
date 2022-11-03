package onboarding.cryptogram;

import static onboarding.cryptogram.CryptogramRegexType.*;

public class CryptogramDecoder {

	private static final int MAX_LENGTH = 1000;

	private static final int MIN_LENGTH = 1;

	static boolean isValidFormat(final String cryptogram) {
		return cryptogram != null
			&& !isOutOfBound(cryptogram)
			&& cryptogram.matches(FORMAT_MATCH_REGEX);
	}

	static boolean isOutOfBound(final String cryptogram) {
		int length = cryptogram.length();
		return MIN_LENGTH > length || length > MAX_LENGTH;
	}

	public static String decrypt(final String cryptogram) {
		String clearText = cryptogram;
		String tmp = removeRepetitions(cryptogram);

		while (tmp.length() != clearText.length()) {
			clearText = tmp;
			tmp = removeRepetitions(clearText);
		}
		return clearText;
	}

	static String removeRepetitions(final String cryptogram) {
		return cryptogram.replaceAll(REPEATED_REMOVAL_REGEX, "");
	}
}
