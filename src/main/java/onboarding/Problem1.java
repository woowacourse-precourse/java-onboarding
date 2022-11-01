package onboarding;

import java.util.List;

class Problem1 {

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int compareToScore(int pobisResult, int crongsResult) {
        if (pobisResult == crongsResult) {
            return DRAW;
        }

        if (pobisResult > crongsResult) {
            return POBI_WIN;
        }

        return CRONG_WIN;
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
