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

        if (checkParam(number))
            return -1;
        if (dp == null)
            initDp();
        if (number == 10000)
            return dp[4];
        for (int i=4; i>0; i--)
        {
            int flag = (int) Math.pow(10, i - 1);
            int cnt = number / flag;

            if (cnt == 0)
                continue;
            answer += dp[i - 1] * cnt;
            if (cnt == 3 || cnt == 6 || cnt == 9) {
                answer += flag * (cnt / 3 - 1);
                answer += (number % flag + 1);
            }
            else
                answer += flag * (cnt / 3);
            number %= flag;
        }
        return answer;
    }
}
