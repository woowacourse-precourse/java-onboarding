package onboarding;

/**
 * 기능 구현 사항
 * 1. 연속된 문자열 삭제 함수
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = deleteChar(cryptogram);
        return answer;
    }
}
