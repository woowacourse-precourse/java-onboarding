package onboarding;

public class Problem4 {

	public static final int ASCII_CAPITAL_A = 65;
	public static final int ASCII_CAPITAL_Z = 90;
	public static final int ASCII_LOWER_CASE_A = 97;
	public static final int ASCII_LOWER_CASE_Z = 122;
	public static final int ASCII_CAPITAL_CALCULATION_NUMBER = 155;
	public static final int ASCII_LOWER_CASE_CALCULATION_NUMBER = 219;

	public static String solution(String word) {

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			answer.append(getReversedAlphabet(getAscii(word.charAt(i))));
		}

		return answer.toString();
	}

	private static int getAscii(Character character) {
		return (int) character;
	}

	private static Character getReversedAlphabet(int ascii) {

		int reversedAscii = ascii;

		if (ascii >= ASCII_CAPITAL_A && ascii <= ASCII_CAPITAL_Z) {
			reversedAscii = ASCII_CAPITAL_CALCULATION_NUMBER - ascii;
		}

		if (ascii >= ASCII_LOWER_CASE_A && ascii <= ASCII_LOWER_CASE_Z) {
			reversedAscii = ASCII_LOWER_CASE_CALCULATION_NUMBER - ascii;
		}

		return (Character) (char) reversedAscii;
	}

}
