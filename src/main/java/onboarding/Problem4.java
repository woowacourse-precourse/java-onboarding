package onboarding;

public class Problem4 {

	public static final int asciiCapitalA = 65;
	public static final int asciiCapitalZ = 90;
	public static final int asciiLowerCaseA = 97;
	public static final int asciiLowerCaseZ = 122;
	public static final int asciiCapitalCalculationNumber = 155;
	public static final int asciiLowerCaseCalculationNumber = 219;

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

		if (ascii >= asciiCapitalA && ascii <= asciiCapitalZ) {
			reversedAscii = asciiCapitalCalculationNumber - ascii;
		}

		if (ascii >= asciiLowerCaseA && ascii <= asciiLowerCaseZ) {
			reversedAscii = asciiLowerCaseCalculationNumber - ascii;
		}

		return (Character) (char) reversedAscii;
	}

}
