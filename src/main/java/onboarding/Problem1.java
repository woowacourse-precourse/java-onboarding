package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int sumOfDigits(int page) {
        int sum = 0;

        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    private static int productOfDigits(int page) {
        int product = 1;

        while (page > 0) {
            product *= page % 10;
            page /= 10;
        }

        return product;
    }
}
