package onboarding;

public class Problem3 {

    private static int[] dp;

    private static boolean checkParam(int n)
    {
        return n == 0 || 10000 < n;
    }

    private static void initDp()
    {
        dp = new int[5];
        dp[0] = 0;
        for (int i=0; i<4; i++)
            dp[i + 1] = 3 * (int) Math.pow(10, i) + dp[i] * 10;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
