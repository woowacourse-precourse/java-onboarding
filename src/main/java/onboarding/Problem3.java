package onboarding;

public class Problem3 {
    static final int MAX_NUM = 10_000;
    static int[] dp; // dp[i] : 1~i 까지 쳐야하는 손뼉의 총 갯수

    public static int solution(int number) {
        // 1 부터 number 까지의 손뼉을 쳐야 하는 횟수
        dp = new int[MAX_NUM + 1];

        // init
        dp[1] = 0;

        // start
        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i - 1] + calc(i);
        }
        return dp[number];
    }

    private static int calc(int num) {
        int res = 0;
        int q = num;
        while (q > 0) {
            int r = (q % 10);
            if(r != 0 && r % 3 == 0) res++;
            q /= 10;
        }

        return res;
    }
}
