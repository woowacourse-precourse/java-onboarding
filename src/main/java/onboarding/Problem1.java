package onboarding;

import java.util.List;

class Problem1 {
    private static int sum(Integer num) {
        int ans = 0;
        while(num > 0) {
            ans += (num%10);
            num /= 10;
        }
        return ans;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int answer = Integer.MAX_VALUE;
            return answer;
        } catch (Exception e) {
            return -1;
        }
    }
}