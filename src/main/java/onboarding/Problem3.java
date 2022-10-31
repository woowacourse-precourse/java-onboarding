package onboarding;

import java.util.*;

public class Problem3 {
    public static int solution(int number) {
        Integer[] dp = new Integer[10001];

        dp[1] = 0;
        for(int i = 2; i < 10001; i++){
            String str = Integer.toString(i);
            int cnt = 0;
            for(char c : str.toCharArray()){
                if(c == '3' || c == '6' || c == '9')    cnt++;
            }
            dp[i] = dp[i-1] + cnt;
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[number];
    }
}
