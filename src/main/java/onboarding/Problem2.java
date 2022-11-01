package onboarding;

public class Problem2 {

	static final String DUPLICATION_REGEX = "(.)\\1+"; // 문자가 2개 이상 있는지 확인하는 정규표현식

	public static String solution(String cryptogram) {
		String answer;

		while (checkDuplication(cryptogram)) {
			cryptogram = removeDuplication(cryptogram);

		}

		answer = cryptogram;
		return answer;
	}

	private static boolean checkDuplication(String str) {
		for (int i = 0; i < str.length() - 1; i++)
			if (str.charAt(i) == str.charAt(i + 1)) {
				return true;
			}

		return false;
	}

	private static String removeDuplication(String str) {
		return str.replaceAll(DUPLICATION_REGEX, "");
	}

}
