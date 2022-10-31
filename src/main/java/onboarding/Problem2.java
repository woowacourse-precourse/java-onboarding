package onboarding;

/**
 * 기능목록
 * 1. 중복된 문자열을 찾는다.
 * 2. 중복된 문자열을 지운다. -> 그 부분만 제외 하고 String builder 로 재생성.
 */
// cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
// cryptogram은 알파벳 소문자로만 이루어져 있다.
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public int findIndexIfDuplicate(String value) {
        for (int i = 0; i < value.length() - 1; i++) {
            if (value.charAt(i) == value.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }
}
