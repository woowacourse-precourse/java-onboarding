package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		return answer;
	}

	public boolean checkContinuity(String cryptogram) {
		char previousC = ' ';
		for (char c : cryptogram.toCharArray()) {
			if (previousC == c) {
				return true;
			}
			previousC = c;
		}
		return false;
	}
}
