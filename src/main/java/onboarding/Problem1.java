package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptional(pobi, crong)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean exceptional(List<Integer> pobi, List<Integer> crong) {
        return !PageValidator.validate(pobi) || !PageValidator.validate(crong);
    }

    private static int sum(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static int multiply(int page) {
        int result = 1;
        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }
}
