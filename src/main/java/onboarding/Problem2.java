package onboarding;

public class Problem2 {
        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 1000;
    public static String solution(String cryptogram) {
        String errorMessage = null;

        if ((errorMessage = verifyException(cryptogram)) != null) {
            return errorMessage;
        }
        String answer = "answer";
        return answer;
    }

    private static String verifyException(String cryptogram) {
        String result = null;

        /* [TODO] 에러 메세지 enum으로 ..? 어떻게 변경할지 고려해보자 */
        if (!isLowerCase(cryptogram))
            result = "Error: Must be lowercase";
        if (result == null && !checkLength(cryptogram)) {
            result = "Error: Length 1 to 1000";
        } else if (!checkLength(cryptogram))
            result = "Error: Length 1 to 1000 and Must be lowercase";
        return result;
    }

    private static boolean isLowerCase(String cryptogram) {
        for (char c : cryptogram.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLength(String cryptogram) {
        return (cryptogram.length() >= MIN_LENGTH && cryptogram.length() <= MAX_LENGTH);
    }
}
