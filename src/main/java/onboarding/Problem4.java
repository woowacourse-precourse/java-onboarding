package onboarding;

public class Problem4 {
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

		if (ascii >= 65 && ascii <= 90) {
			reversedAscii = 155 - ascii;
		}

		if (ascii >= 97 && ascii <= 122) {
			reversedAscii = 219 - ascii;
		}

		return (Character) (char) reversedAscii;
	}

}
