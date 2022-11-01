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

        return modifyString(cryptogram);
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
    private static String modifyString(String cryptogram) {
        duplicateFlag = true;
        StringBuilder sb = new StringBuilder(cryptogram);

        while (duplicateFlag) {
            duplicateFlag = false;
            getIndex(sb.toString());
            if (duplicateFlag) {
                sb.delete(start, end + 1);
            }
        }
        return sb.toString();
    }
    private static void getIndex(String str) {
        char preCh = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (!duplicateFlag && str.charAt(i) == str.charAt(i + 1)) {
                duplicateFlag = true;
                start = i;
                preCh = str.charAt(i);
            } else if (duplicateFlag && preCh != str.charAt(i + 1)) {
                break;
            }
            end = i + 1;
        }
    }
}
