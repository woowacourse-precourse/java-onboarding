package onboarding;

public class Problem2 {
	private static final String REPEAT_REGEX = "{2,}";
	private static final String LOWERCASE_REGEX = "^[a-z]*$";
	private static final String REMOVE_BLANK = "";
	private static final int MIN_CRYPTOGRAM_LENGTH = 1;
	private static final int MAX_CRYPTOGRAM_LENGTH = 1000;

	public static String solution(String cryptogram) {
		if (!checkCryptogramForm(cryptogram)) {
			throw new IllegalArgumentException();
		}
		String plainText = cryptogram;
		int cryptogramLength;
		do {
			cryptogramLength = plainText.length();
			plainText = removeString(plainText);
		} while (checkMatching(cryptogramLength, plainText.length()));
		return plainText;
	}

	private static boolean checkCryptogramForm(String cryptogram) {
		return isLowerCase(cryptogram) && checkCryptogramLength(cryptogram);
	}

	private static boolean isLowerCase(String cryptogram) {
		return cryptogram.matches(LOWERCASE_REGEX);
	}

	private static boolean checkCryptogramLength(String cryptogram) {
		return cryptogram.length() >= MIN_CRYPTOGRAM_LENGTH && cryptogram.length() <= MAX_CRYPTOGRAM_LENGTH;
	}

	private static String removeString(String plainText) {
		for (char alphabet : plainText.toCharArray()) {
			plainText = plainText.replaceAll(alphabet + REPEAT_REGEX, REMOVE_BLANK);
		}
		return plainText;
	}

	private static boolean checkMatching(int cryptogram, int plainText) {
		return cryptogram == plainText;
	}
}
