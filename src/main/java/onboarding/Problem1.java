package onboarding;

import java.util.List;

class Problem1 {
    private static int plusPlaceValue(int page) {
        int result = 0;
        while(page > 0) {
            result += page % 10;
            page /= 10;
        }

        return result;
    }
    private static int multiplyPlaceValue(int page) {
        int result = 1;
        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}