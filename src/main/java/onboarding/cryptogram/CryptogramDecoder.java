package onboarding.cryptogram;

import static onboarding.cryptogram.CryptogramRegexType.*;

public class CryptogramDecoder {

	private static final int MAX_LENGTH = 1000;

	private static final int MIN_LENGTH = 1;

	static boolean isValidFormat(final String cryptogram) {
		return cryptogram != null
			&& validateLength(cryptogram)
			&& cryptogram.matches(FORMAT_MATCH_REGEX);
	}

	static boolean validateLength(final String cryptogram) {
		int length = cryptogram.length();
		return MIN_LENGTH <= length && length <= MAX_LENGTH;
	}

	public static String decrypt(final String cryptogram) {
		String clearText = cryptogram;
		while (containsRepetitions(clearText)) {
			clearText = removeRepetitions(clearText);
		}
		return clearText;
	}

	static boolean containsRepetitions(final String cryptogram) {
		return cryptogram.matches(REPEATED_MATCH_REGEX);
	}

	static String removeRepetitions(final String cryptogram) {
		return cryptogram.replaceAll(REPEATED_REMOVAL_REGEX, "");
	}
}
