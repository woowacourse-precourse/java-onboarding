package onboarding;

public class Problem4 {
	private static final String EXCEPTION_MESSAGE = "ERROR";
    public static String solution(String word) {
		if (!isValidLength(word.length())) {
			return getExceptionMessage();
		}
        return answer;
    }

	private static boolean isValidLength(int length) {
		return length >= 1 && length <= 1000;
	}

	private static String getExceptionMessage() {
		return EXCEPTION_MESSAGE;
	}

}
