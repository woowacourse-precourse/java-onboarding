package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    private static boolean duplicateFlag;
    private static int STRING_MIN_LENGTH = 1;
    private static int STRING_MAX_LENGTH = 1000;
    private static int start;
    private static int end;

    public static String solution(String cryptogram) {
        validityChecker(cryptogram);

        String answer = "answer";
        return answer;
    }
    private static void validityChecker(String cryptogram) {
        if (!isValidLength(cryptogram)) {
            throw new IllegalArgumentException("암호문의 길이가 1이상 1000이하가 아닙니다");
        }
        if (!isVaildCompo(cryptogram)) {
            throw new IllegalArgumentException("암호문의 구성요소가 소문자로 이루어지지 않았습니다");
        }
    }
    private static boolean isValidLength(String cryptogram) {
        int stringLength = cryptogram.length();

        return STRING_MIN_LENGTH <= stringLength && stringLength <= STRING_MAX_LENGTH;
    }
    private static boolean isVaildCompo(String cryptogram) {
        return Pattern.matches("^[a-z]*$", cryptogram);
    }

}
