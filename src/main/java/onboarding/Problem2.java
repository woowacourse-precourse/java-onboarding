package onboarding;

import java.util.regex.Pattern;

/**
 * 1. 정규식 초기화
 * 2. 정규식으로 pattern 객체 생성
 * 3. cryptogram 으로 matcher 변수 생성
 * 4. 정규식과 matches 되는 동안 연속된 문자열 삭제
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // 1. 정규식 초기화
        String regex = "^\\w*(\\w)\\1\\w*$";

        // 2. 정규식으로 pattern객체 생성
        Pattern pattern = Pattern.compile(regex);

        return answer;
    }
}
