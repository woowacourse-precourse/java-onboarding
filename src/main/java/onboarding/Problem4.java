package onboarding;

public class Problem4 {

    /**
     * 기능 목록
     * 1. 문자 대문자, 소문자 판단
     * 2. 청개구리 사전
     */

    /**
     * 1. 문자 대문자, 소문자 판단
     * @param a : 비교 문자
     * @return : 대문자 = 1, 소문자 = 2, 그 외의 문자 = -1
     */

    static int checkCapital(char a){
        // 대문자
        if (a >= 65 && a <= 90) return 1;
        // 소문자
        if (a >= 97 && a <= 122) return 2;
        // 그 외의 문자
        return -1;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
