package onboarding;

public class Problem2 {
	private static final String EXCEPTION_MESSAGE = "ERROR";

	public static String solution(String cryptogram) {
		if (!isValidLowerCase(cryptogram) || !isValidLength(cryptogram)) {
			return getExceptionMessage();
		}

		String answer = decodeString(cryptogram);
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

	private static String getExceptionMessage() {
		return EXCEPTION_MESSAGE;
	}

	private static boolean isDecoded(String cryptogram) {
		for (int i = 0; i < cryptogram.length() - 1; i++) {
			if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	private static String decodeString(String cryptogram) {
		if (isDecoded(cryptogram)) {
			return cryptogram;
		}
		for (int i = 0; i < cryptogram.length() - 1; i++) {
			if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
				String next = cryptogram.replaceAll("(([a-z])\\2{1,})", "");
				return decodeString(next);
			}
		}
		return getExceptionMessage();
	}
}
