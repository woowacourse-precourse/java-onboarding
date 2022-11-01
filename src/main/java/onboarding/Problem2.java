package onboarding;

import java.util.regex.Pattern;

public class Problem2 {

	public static final char ALPHABET_START = 'a';
	public static final char ALPHABET_END = 'z';
	public static final String DUPLICATE = "{2,}";
	public static final String PLEASE_ENTER_RIGHT_CRYPTOGRAM = "정확한 암호문을 입력해주세요.";
	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 1000;
	public static final String REPLACE_VALUE = "";
	public static final int FIRST = 0;
	public static final String LOWER_CASE_ALPHABET = "^[a-z]*$";

	public static String solution(String cryptogram) {

		validateCryptogram(cryptogram);

		return removeDuplicateWord(cryptogram);
	}

	private static String removeDuplicateWord(String cryptogram) {
		int originLength = cryptogram.length();
		int count = 0;

		while (isDifferent(cryptogram, originLength, count)) {
			originLength = cryptogram.length();
			count++;
			cryptogram = removeDuplicateAlphabet(cryptogram);
		}

		return cryptogram;
	}

	private static boolean isDifferent(String cryptogram, int originLength, int count) {
		return count == FIRST || isDifferent(cryptogram, originLength);
	}

	private static void validateCryptogram(String cryptogram) {
		if (validateLengthAndAlphabet(cryptogram)) {
			throw new IllegalArgumentException(PLEASE_ENTER_RIGHT_CRYPTOGRAM);
		}
	}

	private static boolean validateLengthAndAlphabet(String cryptogram) {
		return validateLength(cryptogram) || validateAlphabet(cryptogram);
	}

	private static boolean validateLength(String cryptogram) {
		return cryptogram.length() < MIN_LENGTH || cryptogram.length() > MAX_LENGTH;
	}

	private static boolean validateAlphabet(String cryptogram) {
		if (isLowerCase(cryptogram)) {
			return false;
		}

		return true;
	}

	private static boolean isLowerCase(String cryptogram) {
		return Pattern.matches(LOWER_CASE_ALPHABET, cryptogram);
	}

	private static String removeDuplicateAlphabet(String cryptogram) {
		for (char c = ALPHABET_START; c <= ALPHABET_END; c++) {
			StringBuilder duplicateAlphabetRegex = getRegex(c);
			cryptogram = cryptogram.replaceAll(duplicateAlphabetRegex.toString(), REPLACE_VALUE);
		}
		return cryptogram;
	}

	private static boolean isDifferent(String cryptogram, int originLength) {
		return cryptogram.length() != originLength;
	}

	private static StringBuilder getRegex(char alphabet) {
		StringBuilder duplicateAlphabet = new StringBuilder();
		duplicateAlphabet.append(alphabet)
				.append(DUPLICATE);
		return duplicateAlphabet;
	}
}
