package onboarding.cryptogram;

public class CryptogramDecoder {

	private static final int MAX_LENGTH = 1000;

	private static final int MIN_LENGTH = 1;

	public static boolean validateLength(final String cryptogram) {
		int length = cryptogram.length();
		return MIN_LENGTH <= length && length <= MAX_LENGTH;
	}
}
