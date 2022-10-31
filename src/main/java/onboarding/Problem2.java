package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        /*
         * 더 이상 연속하는 중복 문자들이 없어질 때까지 반복하여 결과를 구한다.
         */

        String answer = "answer";
        String pattern = "([a-z])\\1+"; // 알파벳 소문자들만인 동시에 연속하는 중복 문자들을 찾아주는 정규식

        return cryptogram;
    }

    public static String removeConsecutiveDuplicates(String cryptogram, String pattern){
        return cryptogram.replaceAll(pattern, "");
    }

}
