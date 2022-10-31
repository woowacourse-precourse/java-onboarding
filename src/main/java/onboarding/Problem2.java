package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String LOWERCASE_REG = "^[a-z]*$";

    public static String solution(String cryptogram) {
        checkException(cryptogram);
        String answer = getAnswer(cryptogram);
        return answer;
    }

    public static void checkException(String cryptogram) {
        if (!isValidLengthStringException(cryptogram)) {
            throw new IllegalArgumentException("유효한 문자열의 길이를 입력해주세요. (1~1000 자)");
        }
        if(!isLowerCaseString(cryptogram)) {
            throw new IllegalArgumentException("유효한 문자를 입력해주세요. 문자는 소문자로만 이루어져 있습니다.");
        }
    }

    public static boolean isLowerCaseString(String cryptogram) {
        return cryptogram.matches(LOWERCASE_REG);
    }

    public static boolean isValidLengthStringException(String cryptogram) {
        int length = cryptogram.length();
        return length >= MIN_LENGTH && length <= MAX_LENGTH;
    }

    public static String getAnswer(String cryptogram) {
        while (true) {
            if (isLengthZero(cryptogram) || isNotMoreDelete(cryptogram))
                break;

            cryptogram = deleteOverlapChar(cryptogram);
        }
        return cryptogram;
    }

    public static boolean isLengthZero(String cryptogram) {
        boolean isLengthZero = cryptogram.length() == 0 ? true : false;
        return isLengthZero;
    }

    public static boolean isNotMoreDelete(String cryptogram) {
        boolean isNotMoreDelete = true;
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                return false;
            }
        }
        return isNotMoreDelete;
    }

    public static String deleteOverlapChar(String cryptogram) {
        List<Integer> deleteIndexOfCharAt = new ArrayList<>();
        StringBuilder sb = new StringBuilder(cryptogram);
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < sb.length(); i++) {
            char now = sb.charAt(i);
            if (now == sb.charAt(i - 1)) {
                deleteIndexOfCharAt.add(i - 1);
                deleteIndexOfCharAt.add(i);
            }
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!deleteIndexOfCharAt.contains(i)) {
                result.append(cryptogram.charAt(i));
            }
        }

        return result.toString();
    }
}
