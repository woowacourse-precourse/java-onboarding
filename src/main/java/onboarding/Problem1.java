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

        /*
        * p_max : 포비의 최대값 변수
        * c_max : 크롱의 최대값 변수
        */
        int p_max = Integer.MIN_VALUE;
        int c_max = Integer.MIN_VALUE;

        /* 예외 처리 기능 */
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1))
            return -1;

        for (int i = 0; i < 2; i++) {
            int p = pobi.get(i);
            int c = crong.get(i);

            /* 최대값 구하는 기능 */
            p_max = Math.max(p_max, Math.max(hap(p), mul(p)));
            c_max = Math.max(c_max, Math.max(hap(c), mul(c)));
        }

        /* 포비의 최대값과 크롱의 최대값을 비교하는 기능 */
        if (p_max > c_max) answer = 1;
        else if (p_max < c_max) answer = 2;
        else answer = 0;

        return answer;
    }
}