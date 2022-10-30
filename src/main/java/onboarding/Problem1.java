package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static int searchMaxNum(Integer num) {
        int mutiply = 1;
        int sum = 0;
        while (num != 0) {
            mutiply *= num % 10;
            sum += num % 10;
            num /= 10;
        }
        return Math.max(mutiply, sum);
    }
}