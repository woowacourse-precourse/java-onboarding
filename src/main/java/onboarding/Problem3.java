package onboarding;

/**
 * [기능 구현]
 * 1. 주어진 숫자의 각 자릿수의 수 중 3,6,9의 개수를 세는 메소드
 */
public class Problem3 {
    private static int doClap(int num) {
        int cnt = 0;

        while (num > 0) {
            int rem = num % 10;
            if (rem == 3 || rem == 6 || rem == 9) cnt++;
            num /= 10;
        }

        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
