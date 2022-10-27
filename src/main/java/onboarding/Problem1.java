package onboarding;

import java.util.List;

class Problem1 {
    /* 각각의 자리를 더하는 기능 */
    public static int hap(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    /* 각각의 자리를 곱하는 기능 */
    public static int mul(int n) {
        int sum = 1;
        while (n > 0) {
            sum *= (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /* 예외 처리 기능 */
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1))
            return -1;

        return answer;
    }
}