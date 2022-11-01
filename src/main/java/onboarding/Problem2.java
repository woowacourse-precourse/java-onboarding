package onboarding;

import java.util.regex.Pattern;

/**
 * 기능 요구사항
 * 1. 예외체크
 * 2. 중복제거
 * 3. solution 구현
 */
public class Problem2 {
    private static final String ALLOWED_CHARACTERS ="a-z";
    private static final Pattern pattern = Pattern.compile("[^"+ALLOWED_CHARACTERS+"]");
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 유효성 검사
     * @param text 소문자로만 이루어진 알파벳
     * @return 소문자로 이루어진 연속적인 문자열이 아닌 경우 "" 빈 문자열 반환.
     */
    private String checkCryptogram(String text){
        if(pattern.matcher(text).matches() ||
        text.length() > 1000 ||
        text.length() < 1) return "";
        return text;
    }


}
