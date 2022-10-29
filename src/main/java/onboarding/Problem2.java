package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

	private static boolean isValidLowerCase(String cryptogram) {
		for (int i = 0; i < cryptogram.length(); i++) {
			if (!Character.isLowerCase(cryptogram.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValidLength(String cryptogram) {
		return cryptogram.length() <= 1000;
	}

}
