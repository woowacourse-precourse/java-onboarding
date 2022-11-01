package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePageNumber(pobi, crong)) {
            return -1;
        }
        int pobiMaxNum = getMaxNumber(pobi);
        int crongMaxNum = getMaxNumber(crong);

        return compareResult(pobiMaxNum, crongMaxNum);
    }

    private static int getMaxNumber(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int maxAddition = Math.max(getMaxAddition(leftPage), getMaxAddition(rightPage));
        int maxMultiplication = Math.max(getMaxMultiplication(leftPage), getMaxMultiplication(rightPage));

        return Math.max(maxAddition, maxMultiplication);
    }

    private static int getMaxMultiplication(int page) {
        int result = 1;

        while (page > 0) {
            int value = page % 10;
            result *= value;
            page /= 10;
        }

        return result;
    }

    private static int getMaxAddition(int page) {
        int result = 0;

        while (page > 0) {
            int value = page % 10;
            result += value;
            page /= 10;
        }

        return result;
    }

    private static boolean validatePageNumber(List<Integer> pobi, List<Integer> crong) {
        return !(pobi.get(1) - pobi.get(0) > 1 || crong.get(1) - crong.get(0) > 1) ? true : false;
    }

    public static int compareResult(int x, int y) {
        return (x - y)> 0 ? 1 : (y - x) > 0 ? 2 : 0;
    }
}