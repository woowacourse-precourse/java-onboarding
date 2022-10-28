package onboarding;

public class Problem2 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 1000;
    static final String INPUT_ERROR = "Input Error";
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (!isValidInput(cryptogram)) {
            answer = INPUT_ERROR;
            return answer;
        }

        return answer;
    }

    private static boolean isValidInput(String cryptogram) {
        return (isNotNull(cryptogram) && isRightLength(cryptogram)
         && isNotConsistedLowerCase(cryptogram));
    }

    private static boolean isNotConsistedLowerCase(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isUpperCase(cryptogram.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotNull(String cryptogram) {
        return cryptogram != null;
    }

    private static boolean isRightLength(String cryptogram) {
        return cryptogram.length() >= MIN_LENGTH && cryptogram.length() <= MAX_LENGTH;
    }
}
