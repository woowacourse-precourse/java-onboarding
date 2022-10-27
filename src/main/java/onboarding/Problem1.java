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
    private static int compareValue(int page) {
        int plusValue = plusPlaceValue(page);
        int multiplyValue = multiplyPlaceValue(page);

        return Math.max(plusValue, multiplyValue);
    }
    private static int getMaxPage(int maxValue, int page) {
        if (maxValue < page) {
            maxValue = page;
        }
        return maxValue;
    }
    private static int getMaxValue(List<Integer> pages){
        int maxValue = 0;
        for (int page : pages) {
            int value = compareValue(page);
            maxValue = getMaxPage(maxValue, value);
        }
        return maxValue;
    }
    private static int getResult(int pobiMax, int crongMax) {
        if (pobiMax == crongMax) {
            return 0;
        } else if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        }
        return -1;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int result = 0;
        int pobiMax = 0;
        int crongMax = 0;

        pobiMax = getMaxValue(pobi);
        crongMax = getMaxValue(crong);
        result = getResult(pobiMax, crongMax);

        return result;
    }
}