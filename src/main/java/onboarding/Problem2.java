package onboarding;

public class Problem2 {

	public static final char ALPHABET_START = 'a';
	public static final char ALPHABET_END = 'z';
	public static final String DUPLICATE = "{2,}";
	public static final String PLEASE_ENTER_RIGHT_CRYPTOGRAM = "정확한 암호문을 입력해주세요.";

	public static String solution(String cryptogram) {

		if (validateCryptogram(cryptogram)) {
			throw new IllegalArgumentException(PLEASE_ENTER_RIGHT_CRYPTOGRAM);
		}

		while (true) {
			int originLength = cryptogram.length();
			cryptogram = removeDuplicateAlphabet(cryptogram);

			if (isSame(cryptogram, originLength)) {
				break;
			}
		}

		return cryptogram;
	}

	private static boolean validateCryptogram(String cryptogram) {
		return validateLength(cryptogram) || validateAlphabet(cryptogram);
	}

	private static boolean validateLength(String cryptogram) {
		return cryptogram.length() < 1 || cryptogram.length() > 1000;
	}

	private static boolean validateAlphabet(String cryptogram) {
		for (int i = 0; i < cryptogram.length(); i++) {
			char alphabet = cryptogram.charAt(i);

			if (isCapitalLetter(alphabet)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCapitalLetter(char alphabet) {
		return alphabet >= 'A' && alphabet <= 'Z';
	}

	private static String removeDuplicateAlphabet(String cryptogram) {
		for (char c = ALPHABET_START; c <= ALPHABET_END; c++) {
			StringBuilder duplicateAlphabetRegex = getRegex(c);
			cryptogram = cryptogram.replaceAll(duplicateAlphabetRegex.toString(), "");
		}
		return cryptogram;
	}

	private static boolean isSame(String cryptogram, int originLength) {
		return cryptogram.length() == originLength;
	}

	private static StringBuilder getRegex(char alphabet) {
		StringBuilder duplicateAlphabet = new StringBuilder();
		duplicateAlphabet.append(alphabet)
				.append(DUPLICATE);
		return duplicateAlphabet;
	}
}
