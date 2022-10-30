package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static int add(int num) {
        int result = 0;
        while (num > 0) {
            result += (num % 10);
            num /= 10;
        }
        return result;
    }

    static int multiply(int num) {
        int result = 1;
        while (num > 0) {
            result *= (num % 10);
            num /= 10;
        }
        return result;
    }

    static int getMax(List<Integer> scores) {
        int max = Integer.MIN_VALUE;
        for (Integer score : scores)
            if (max < score) max = score;
        return max;
    }

}