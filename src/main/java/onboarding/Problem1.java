package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        findMaxValue(pobi);
        findMaxValue(crong);
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int findMaxValue(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftSumValue = calculateSumValue(leftPage);
        int rightSumValue = calculateSumValue(rightPage);

        return 0;
    }

    private static int calculateSumValue(int page) {
        int result = 0;

        while (page > 1) {
            result += page % 10;
            page /= 10;
        }

        return result;
    }

}