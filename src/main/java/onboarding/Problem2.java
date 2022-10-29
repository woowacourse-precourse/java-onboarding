package onboarding;

/*
* 기능 목록
* 1. 연속되는 값을 판별하는 기능
* 2. 연속되는 값들을 제거하는 기능
*
* */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static int isContinuous(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) return i;
        }
        return - 1;
    }
}
