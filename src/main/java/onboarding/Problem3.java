package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    static int[] dp = Stream.generate(() -> 0).limit(10000 + 1).mapToInt(v -> v).toArray();

    public static boolean check369(int n) {
        return n > 0 && n < 10 && n % 3 == 0;
    }
    
    public static int solution(int number) {
        if (dp[number] > 0) {
            return dp[number];
        } else {
            int answer = 0;
            for (int n = 1; n < 10 && n < number; n++)
                if (check369(n)) {
                    dp[n] = 1;
                    answer++;
                }

            for (int n = 10; n <= number; n++) {
                dp[n] = dp[n / 10] + dp[n % 10];
                answer += dp[n];
            }

            return answer;
        }
    }
}
