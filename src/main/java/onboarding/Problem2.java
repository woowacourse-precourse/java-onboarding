package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";

		while (checkDuplication(cryptogram)) {

		}

		return answer;

	}

	private static boolean checkDuplication(String str) {

		for (int i = 0; i < str.length() - 1; i++)
			//중복이 있을 경우
			if (str.charAt(i) == str.charAt(i + 1)) {
				return true;
			}

		// 중복이 없을 경우
		return false;
	}

}
