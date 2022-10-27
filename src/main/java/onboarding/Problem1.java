package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private int addDigits(int num) {
        int sum = 0;
        while(num == 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int multipleDigits(int num) {
        int multiple = 1;
        while(num == 0) {
            multiple *= num % 10;
            num /= 10;
        }
        return multiple;
    }
}