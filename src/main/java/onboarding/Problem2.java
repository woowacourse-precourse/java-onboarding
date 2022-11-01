package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * isProperCryptogram 메서드 암호문이 적절한지 확인
 * getDecodingCryptogram 메서드 해독된 암호문을 반환
 * isLengthZero 암호문의 길이가 0인지 확인
 * isDecodingCryptogram 암호해독이 완료됐는지 확인
 * deleteOverlap 중복된 문자열을 제거 하여 반
 */
public class Problem2 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String LOWERCASE = "^[a-z]*$";

    public static String solution(String cryptogram) {
        isProperCryptogram(cryptogram);
        return getDecodingCryptogram(cryptogram);
    }


    private static void isProperCryptogram(String cryptogram) {
        if (cryptogram.length() < MIN_LENGTH || cryptogram.length() > MAX_LENGTH)
            throw new IllegalArgumentException("cryptogram의 길이는 1이상 1000이하인 문자열입니다.");
        if (!cryptogram.matches(LOWERCASE))
            throw new IllegalArgumentException("cryptogram은 소문자로만 이루어져 있어야합니다.");
    }

    private static String getDecodingCryptogram(String cryptogram) {
        while (true) {
            if (isLengthZero(cryptogram) || isDecodingCryptogram(cryptogram)) break;

            cryptogram = deleteOverlap(cryptogram);
        }
        return cryptogram;
    }

    private static boolean isLengthZero(String cryptogram) {
        return cryptogram.length() == 0 ? true : false;
    }

    private static boolean isDecodingCryptogram(String cryptogram) {
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) return false;
        }
        return true;
    }

    private static String deleteOverlap(String cryptogram) {
        List<Integer> overlapIndex = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                overlapIndex.add(i - 1);
                overlapIndex.add(i);
            }
        }
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!overlapIndex.contains(i)) result.append(cryptogram.charAt(i));
        }
        return result.toString();
    }
}
