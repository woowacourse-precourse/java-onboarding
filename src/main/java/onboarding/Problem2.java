package onboarding;

public class Problem2 {

	static String answer;

	public static String solution(String cryptogram) {
		answer = cryptogram.substring(0, 1);
		cryptogram = cryptogram.substring(1);
		char[] chars = cryptogram.toCharArray();

		for (Character c : chars) {
			answer += String.valueOf(c);
			checkEndChars();
		}

		return answer;
	}

	private static void checkEndChars() {
		char c1 = answer.charAt(answer.length() - 2);
		char c2 = answer.charAt(answer.length() - 1);
		if (c1 == c2) {
			answer = answer.substring(0, answer.length() - 2);
		}
	}
}
