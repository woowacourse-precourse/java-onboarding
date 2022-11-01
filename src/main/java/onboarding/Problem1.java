package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getMul(int n, int mul) {
        while(n / 10 != 0 || n % 10 != 0) {
            mul *= n % 10;
            n /= 10;
        }
        return mul;
    }
}