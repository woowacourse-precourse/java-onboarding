package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private int selectOperation(int num) {
        int sum = 0;
        int multiple = 1;

        while (num != 0) {
            sum += num % 10;
            multiple *= num % 10;
            num /= 10;
        }
        return Math.max(sum, multiple);
    }
}