package onboarding;

/*
1. 중복 문자 체크
2. 중복 문자 제거
 */

public class Problem2 {

    private static int checkOverlap(String word) {
        for (int i = 1; i < word.length(); i ++) {
            if (word.charAt(i - 1) == word.charAt(i))
                return 1;
        }
        return 0;
    }

    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }
}
