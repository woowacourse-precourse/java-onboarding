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

		if (classifyCaseSensitive(ascii).equals("Capital")) {
			return (Character) (char) calculateAsciiForReversion(ascii, ASCII_CAPITAL_CALCULATION_NUMBER);
		}

		if (classifyCaseSensitive(ascii).equals("LowerCase")) {
			return (Character) (char) calculateAsciiForReversion(ascii, ASCII_LOWER_CASE_CALCULATION_NUMBER);
		}

		return (Character) (char) ascii;
	}

	private static int calculateAsciiForReversion(int ascii, int calculationNumber) {
		 return calculationNumber - ascii;
	}

	private static String classifyCaseSensitive(int ascii) {

		if (ascii >= ASCII_CAPITAL_A && ascii <= ASCII_CAPITAL_Z) {
			return "Capital";
		}

		if (ascii >= ASCII_LOWER_CASE_A && ascii <= ASCII_LOWER_CASE_Z) {
			return "LowerCase";
		}

		return "Other";
	}


}
