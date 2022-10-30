package onboarding;

public class Problem2 {

	static String answer;

	public static String solution(String cryptogram) {
		answer = "";
		char[] chars = cryptogram.toCharArray();

		for (Character c : chars) {
			answer += String.valueOf(c);

			if (answer.length() > 1) {
				checkEndChars();
			}
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
