package onboarding;

/**
 * > 요구사항
 * 1. 1부터 number까지 3,6,9가 나온 총 횟수 구하기
 */
public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; ++i) {
            String s = String.valueOf(i);
            cnt += count369(s);
        }
        return cnt;
    }

    private static int count369(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '3' || s.charAt(i) == '6' || s.charAt(i) == '9') {
                cnt += 1;
            }
        }
        return cnt;
    }
}
