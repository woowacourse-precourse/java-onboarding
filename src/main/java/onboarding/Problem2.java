package onboarding;

/** 기능 사항
 * 1. 바꿀 값이 있는지 확인하는 함수
 * 2. 바꿀 값이 있을 경우 바꾸는 함수
 */
public class Problem2 {
    /**
     * 바꿀 값이 있는지 확인하는 함수
     * @param s
     * @return 바꿀값이 시작되는 index를 return
     */
    static int checkPossible(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return i;
        }
        return -1;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
