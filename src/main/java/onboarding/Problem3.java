package onboarding;

public class Problem3 {
    public static int[] dp = new int[100001];
    public static int[] sam = {3, 6, 9};

    public static void init() {
        for (int i = 1; i <= 10000; i++) {
            int temp = i;
            int plus = 0;
            while (temp != 0) {
                for (int j = 0; j < 3; j++) {
                    if (temp % 10 == sam[j])
                        plus++;
                }
                temp /= 10;
            }

            dp[i] = dp[i - 1] + plus;
        }
    }

    public static int solution(int number) {
        init();
        int answer = dp[number];
        return answer;
    }
}
