package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		return answer;
	}

	private static boolean isDuplicate(String cryptogram) {
		for (int i = 1; i < cryptogram.length(); i++) {
			if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
				return true;
			}
		}
		return false;
	}
}
