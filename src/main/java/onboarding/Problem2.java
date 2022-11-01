package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

/**
 * 기능 목록
 * 1. 입력 문자열 길이 검증;
 * 2. 입력 문자열 소문자 변환;
 * 3. 중복이 포함된 문장 패턴 여부 반환;
 * 4. 중복 문장 제거 후 더 이상 중복 문장 패턴이 발견되지 않을 때 까지 탐색;
 */
public class Problem2 {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String REGEX_MATCHES = "[a-z]*([a-z])\\1+[a-z]*";
    private static final String REGEX_FIND = "([a-z])\\1+";

    public static String solution(String cryptogram) {
        return !isValidLength(cryptogram) ? cryptogram : reduceDupChars(convertToLowercase(cryptogram));
    }

    static boolean isValidLength(String cryptogram) {
        int len = cryptogram.length();
        return len >= MIN_LENGTH && len <= MAX_LENGTH;
    }

    static String convertToLowercase(String cryptogram) {
        return cryptogram.toLowerCase();
    }

    /**
     * 정규표현식으로 탐색
     * @param cryptogram
     */
    static boolean hasDupChars(String cryptogram) {
        return cryptogram.matches(REGEX_MATCHES);
    }

    /**
     * 정규 표현식을 이용해 2개 이상의 중복 문자가 있는지 탐색
     * 중복 문자의 개수만큼 반복하며, 중복 문자를 제거해감
     * @param cryptogram
     */
    static String reduceDupChars(String cryptogram) {
        Pattern ptrn = Pattern.compile(REGEX_FIND);
        while (hasDupChars(cryptogram)) {
            StringBuilder sb = new StringBuilder();
            Matcher matcher = ptrn.matcher(cryptogram);
            while (matcher.find()) {
                matcher.appendReplacement(sb, "");
            }
            matcher.appendTail(sb);
            cryptogram = sb.toString();
        }
        return cryptogram;
    }
}
