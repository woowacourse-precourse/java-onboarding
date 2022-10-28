package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {

		String answer = "";
		char[] chars = cryptogram.toCharArray();
		for (Character c : chars) {
			String ch = String.valueOf(c);
			if (answer.endsWith(ch)) {
				answer = answer.substring(0, answer.length() - 1);
			} else {
				answer += ch;
			}
		}
		return answer;
	}
}
