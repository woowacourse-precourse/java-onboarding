package onboarding;

public class Problem4 {
	public static String solution(String word) {
		StringBuilder answer = new StringBuilder();
		for (char nowLetter : word.toCharArray()) {
			answer.append(reverseChar(nowLetter));
		}
		return answer.toString();
	}

	private static char reverseChar(char givenChar) {
		if ('A' <= givenChar && givenChar <= 'Z') {
			return (char)('Z' - givenChar + 'A');
		} else if ('a' <= givenChar && givenChar <= 'z') {
			return (char)('z' - givenChar + 'a');
		}
		return givenChar;
	}
}
