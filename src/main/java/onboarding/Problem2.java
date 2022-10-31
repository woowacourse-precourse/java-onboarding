package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (isException(cryptogram)) throw new RuntimeException("잘못된 인자입니다.");

        //이전 문자열 길이
        Integer len = 1001;
        String decodeString = cryptogram;
        while (len > decodeString.length()) {
            len = decodeString.length();
            decodeString = deduplicate(decodeString);
        }
        return decodeString;
    }

    private static Boolean isException(String str) {
        if (str.length() < 1 || str.length() > 1000) return true;
        return !Pattern.matches("[a-z]*", str);
    }

    private static String deduplicate(String str) {
        return str.replaceAll("(\\w)\\1+", "");
    }
}