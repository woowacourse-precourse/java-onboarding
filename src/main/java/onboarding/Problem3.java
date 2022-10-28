package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    static int lstNumber = 0;
    static int[] dp = Stream.generate(() -> 0).limit(10000 + 1).mapToInt(v -> v).toArray();

    public static boolean check369(int n) {
        return n > 0 && n < 10 && n % 3 == 0;
    }
    
    public static int solution(int number) {
        if (lstNumber >= number) {
            return dp[number];
        } else {
            for (int n = lstNumber + 1; n <= number; n++) {
                dp[n] = dp[n - 1];

                int p = n;
                while (p != 0) {
                    if (check369(p % 10))
                        dp[n]++;
                    p /= 10;
                }
            }
            lstNumber = number;

            return dp[number];
        }
    }
}
