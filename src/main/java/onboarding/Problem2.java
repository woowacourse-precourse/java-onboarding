package onboarding;

public class Problem2 {
	private static void solveCryptogram(char ch, StringBuffer answer) {
		if (answer.length() > 0 &&
			ch == answer.charAt(answer.length() - 1)) {
			answer.deleteCharAt(answer.length() - 1);
		} else {
			answer.append(ch);
		}
	}

	public static String solution(String cryptogram) {
		StringBuffer answer = new StringBuffer("");
		for (int i = 0; i < cryptogram.length(); i++) {
			solveCryptogram(cryptogram.charAt(i), answer);
		}
		return answer.toString();
	}
}
