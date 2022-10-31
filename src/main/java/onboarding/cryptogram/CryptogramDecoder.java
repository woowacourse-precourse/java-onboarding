package onboarding.cryptogram;

public class CryptogramDecoder {

	private static final int MAX_LENGTH = 1000;

	private static final int MIN_LENGTH = 1;

	private static final String FORMAT_REGEX = "^[a-z]+$";

	private static final String REPEATED_REGEX = ".*(\\w)\\1+.*";

	private static final String REPEATED_REMOVAL_REGEX = "(\\w)\\1+";

	static boolean validateLength(final String cryptogram) {
		int length = cryptogram.length();
		return MIN_LENGTH <= length && length <= MAX_LENGTH;
	}

	static boolean isValidFormat(final String cryptogram) {
		return cryptogram != null
			&& validateLength(cryptogram)
			&& cryptogram.matches(FORMAT_REGEX);
	}

	static boolean containsRepetitions(final String cryptogram) {
		return cryptogram.matches(REPEATED_REGEX);
	}

	static String removeRepetitions(final String cryptogram) {
		return cryptogram.replaceAll(REPEATED_REMOVAL_REGEX, "");
	}

	public static String decode(final String cryptogram) {
		String clearText = cryptogram;
		while (containsRepetitions(clearText)) {
			clearText = removeRepetitions(clearText);
		}
		return clearText;
	}
}
