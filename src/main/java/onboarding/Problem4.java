package onboarding;

public class Problem4 {

	public static final int ALPHABET_SIZE = 26;

	private static char[] reverseUpperLetter;
	private static char[] reverseLowerLetter;

	static {
		initReverseUpperLetter();
		initReverseLowerLetter();
	}

	private static void initReverseUpperLetter() {
		reverseUpperLetter = new char[ALPHABET_SIZE];
		char upperLetter = 'Z';

		for (int i = 0; i < ALPHABET_SIZE; i++) {
			reverseUpperLetter[i] = upperLetter;
			upperLetter--;
		}
	}

	private static void initReverseLowerLetter() {
		reverseLowerLetter = new char[ALPHABET_SIZE];
		char lowerLetter = 'z';

		for (int i = 0; i < ALPHABET_SIZE; i++) {
			reverseLowerLetter[i] = lowerLetter;
			lowerLetter--;
		}
	}

	public static String solution(String word) {
		char[] wordToChars = word.toCharArray();

        StringBuilder result = appendAlphabet(wordToChars);

        return result.toString();
	}

    private static StringBuilder appendAlphabet(char[] wordToChars) {
        StringBuilder result = new StringBuilder();

        for (char wordToChar : wordToChars) {
            if (isUpperCase(wordToChar)) {
                appendReverseUpperAlphabet(result, wordToChar);
                continue;
            }

            if (isLowerCase(wordToChar)) {
                appendReverseLowerAlphabet(result, wordToChar);
                continue;
            }

            result.append(wordToChar);
        }
        
        return result;
    }

    private static boolean isUpperCase(char wordToChar) {
        return 'A' <= wordToChar && wordToChar <= 'Z';
    }

    private static boolean isLowerCase(char wordToChar) {
        return 'a' <= wordToChar && wordToChar <= 'z';
    }

    private static void appendReverseUpperAlphabet(StringBuilder result, char wordToChar) {
        int index = wordToChar - 'A';
        char reverse = reverseUpperLetter[index];
        result.append(reverse);
    }

    private static void appendReverseLowerAlphabet(StringBuilder result, char wordToChar) {
        int index = wordToChar - 'a';
        char reverse = reverseLowerLetter[index];
        result.append(reverse);
    }
}
