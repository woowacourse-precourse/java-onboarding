package onboarding.problem4;

public class FrogDictionary {

	private static final int START_LOWER_ASCII = 'a';
	private static final int END_LOWER_ASCII = 'z';
	private static final int START_UPPER_ASCII = 'A';
	private static final int END_UPPER_ASCII = 'Z';

	public static boolean isAlphabet(char input) {
		return isLowerAlphabet(input) || isUpperAlphabet(input);
	}

	static boolean isLowerAlphabet(char input) {
		return input >= START_LOWER_ASCII && input <= END_LOWER_ASCII;
	}

	static boolean isUpperAlphabet(char input) {
		return input >= START_UPPER_ASCII && input <= END_UPPER_ASCII;
	}
}
