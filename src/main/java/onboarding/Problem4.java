package onboarding;

public class Problem4 {
	public static String solution(String word) {

		String answer = "";
		for (int i = 0; i < word.length(); i++) {
			answer += getReversedAlphabet(getAscii(word.charAt(i)));
		}
		return answer;
	}

	private static int getAscii(Character character) {
		int ascii = (int) character;
		return ascii;
	}

	private static Character getReversedAlphabet(int ascii) {

		int reversedAscii = 0;

		if (ascii >= 65 && ascii <= 90) {
			reversedAscii = 155 - ascii;
		} else if (ascii >= 97 && ascii <= 122) {
			reversedAscii = 219 - ascii;
		} else {
			reversedAscii = ascii;
		}
		Character reversedAlphabet = (char) reversedAscii;

		return reversedAlphabet;
	}

}
