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
        int leftMultiValue = calculateMultiValue(leftPage);
        int rightSumValue = calculateSumValue(rightPage);
        int rightMultiValue = calculateMultiValue(rightPage);

        return Math.max(Math.max(leftSumValue, leftMultiValue), Math.max(rightSumValue, rightMultiValue));
    }

    private static int calculateSumValue(int page) {
        int result = 0;

        while (page > 1) {
            result += page % 10;
            page /= 10;
        }

        return result;
    }

    private static int calculateMultiValue(int page) {
        int result = 1;

        while (page > 1) {
            result *= page % 10;
            page /= 10;
        }

        return result;
    }

}