package onboarding;
/*
    기능 목록
    1. 연속된 문자가 있는지 체크하는 기능 -> checkDup
    2. 연속된 문자를 자르는 기능
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    private static int checkDup(String cryptogram, int i) {
        int ret = 0;

        while(cryptogram.charAt(i) == cryptogram.charAt(i + ret + 1))
            ret++;
        return ret;
    }
}
