package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = getAnswer(cryptogram);
        return answer;
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
