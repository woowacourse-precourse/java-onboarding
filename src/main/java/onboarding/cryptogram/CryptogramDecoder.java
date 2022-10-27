package onboarding.cryptogram;

public class CryptogramDecoder {

	private static final int MAX_LENGTH = 1000;

	private static final int MIN_LENGTH = 1;

	private static final String FORMAT_REGEX = "^[a-z]+$";

	public static boolean validateLength(final String cryptogram) {
		int length = cryptogram.length();
		return MIN_LENGTH <= length && length <= MAX_LENGTH;
	}

	public static boolean isValidFormat(final String cryptogram) {
		return cryptogram != null
			&& validateLength(cryptogram)
			&& cryptogram.matches(FORMAT_REGEX);
	}
}
