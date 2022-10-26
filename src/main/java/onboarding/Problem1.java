package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getSum(int num) {
        int sum = 0;
        while (num < 10) {
            sum += (num % 10);
            num /= 10;
        }
        sum += num;
        return sum;
    }
}