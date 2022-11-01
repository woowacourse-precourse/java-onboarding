package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 1. removeDuplication(): 정규표현식을 반복해서 사용해 중복된 문자를 제거하고 문자열을 반환하는 메서드
 *   1-1. 중복된 문자를 반복적으로 제거
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplication(cryptogram);
    }

    private static String removeDuplication(String cryptogram) {
        Pattern pattern = Pattern.compile("(\\w)\\1+");
        Matcher matcher = pattern.matcher(cryptogram);

        while (matcher.find()) {
            cryptogram = matcher.replaceAll("");
            matcher = pattern.matcher(cryptogram);
        }
        return cryptogram;
    }
}
