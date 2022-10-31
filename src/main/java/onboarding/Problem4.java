package onboarding;

public class Problem4 {

	public static final int ALPHABET_SIZE = 26;
	public static final String WORD_LENGTH_IS_TOO_LONG_OR_SHORT = "문자의 길이가 너무 짧거나 너무 깁니다.";
	public static final int MIN_WORD_LENGTH = 1;
	public static final int MAX_WORD_LENGTH = 1000;
	public static final char UPPER_LETTER_START = 'A';
	public static final char LOWER_LETTER_START = 'a';
	public static final char UPPER_LETTER_END = 'Z';
	public static final char LOWER_LETTER_END = 'z';

	private static char[] reverseUpperLetter;
	private static char[] reverseLowerLetter;

	static {
		initReverseUpperLetter();
		initReverseLowerLetter();
	}

	private static void initReverseUpperLetter() {
		reverseUpperLetter = new char[ALPHABET_SIZE];
		char upperLetter = UPPER_LETTER_END;

		for (int i = 0; i < ALPHABET_SIZE; i++) {
			reverseUpperLetter[i] = upperLetter;
			upperLetter--;
		}
	}

	private static void initReverseLowerLetter() {
		reverseLowerLetter = new char[ALPHABET_SIZE];
		char lowerLetter = LOWER_LETTER_END;

		for (int i = 0; i < ALPHABET_SIZE; i++) {
			reverseLowerLetter[i] = lowerLetter;
			lowerLetter--;
		}
	}

	public static String solution(String word) {
		validateWord(word);

		char[] wordToChars = word.toCharArray();
		StringBuilder result = appendAlphabet(wordToChars);

		return result.toString();
	}

	private static void validateWord(String word) {
		if (word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH) {
			throw new IllegalArgumentException(WORD_LENGTH_IS_TOO_LONG_OR_SHORT);
		}
	}

	private static StringBuilder appendAlphabet(char[] wordToChars) {
		StringBuilder result = new StringBuilder();

		for (char wordToChar : wordToChars) {
			appendWord(result, wordToChar);
		}

		return result;
	}

	private static void appendWord(StringBuilder result, char wordToChar) {
		if (isUpperCase(wordToChar)) {
			appendReverseUpperAlphabet(result, wordToChar);
			return;
		}

		if (isLowerCase(wordToChar)) {
			appendReverseLowerAlphabet(result, wordToChar);
			return;
		}

		result.append(wordToChar);
	}

	private static boolean isUpperCase(char wordToChar) {
		return UPPER_LETTER_START <= wordToChar && wordToChar <= UPPER_LETTER_END;
	}

	private static boolean isLowerCase(char wordToChar) {
		return LOWER_LETTER_START <= wordToChar && wordToChar <= LOWER_LETTER_END;
	}

	private static void appendReverseUpperAlphabet(StringBuilder result, char wordToChar) {
		int index = wordToChar - UPPER_LETTER_START;
		char reverse = reverseUpperLetter[index];
		result.append(reverse);
	}

	private static void appendReverseLowerAlphabet(StringBuilder result, char wordToChar) {
		int index = wordToChar - LOWER_LETTER_START;
		char reverse = reverseLowerLetter[index];
		result.append(reverse);
	}
}
