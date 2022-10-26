package onboarding;

/**
 * 1. word길이 체크
 * 2. 제한 사항 중 "알파벳 외의 문자는 반환하지 않는다. -> 알파벳이 아닌 정보가 들어오면 그대로 출력
 *    => 아스키 코드 값으로 범위 확인
 * 3. String => split => char => ascii(int) => 대소문자 범위 확인 => 변환 => char => String
 */
public class Problem4 {
    public static String solution(String word) {
        checkValidRange(word.length());
        String answer = "";
        return answer;
    }
    public static void checkValidRange(int wordLength) {
        if (wordLength < 1 || wordLength > 1000) {
            throw new IllegalArgumentException();
        }
    }
}
