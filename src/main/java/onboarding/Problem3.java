package onboarding;

/* 기능 목록
1. 한 숫자에서 3, 6, 9 세기
2. 1부터 number 까지 순회
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int count369(String str) {
        return str.length() - str.replaceAll("[369]", "").length();
    }
}
