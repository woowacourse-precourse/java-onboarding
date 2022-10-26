package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static int pageMultiply(Integer page) {
        int multiply = 1;
        while(page > 0) {
            multiply *= page % 10;
            page /= 10;
        }
        return multiply;
    }

    private static int pagePlus(Integer page) {
        int plus = 0;
        while(page > 0) {
            plus += page % 10;
            page /= 10;
        }
        return plus;
    }
}