package onboarding;

import java.util.List;

class Problem1 {
    public static int START_PAGE = 1;
    public static int END_PAGE = 400;

    public static int LEFT_PAGE_IDX = 0;
    public static int RIGHT_PAGE_IDX = 1;

    public static int POBI_WIN = 1;
    public static int CRONG_WIN = 2;
    public static int DRAW = 0;
    public static int ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMaxValue = findMaxValue(pobi);
        int crongMaxValue = findMaxValue(crong);

        if (pobiMaxValue == ERROR || crongMaxValue == ERROR) {
            return ERROR;
        }

        return resultGame(pobiMaxValue, crongMaxValue);
    }

    private static int resultGame(int pobiMaxValue, int crongMaxValue) {
        if (pobiMaxValue == crongMaxValue) {
            return DRAW;
        } else if (pobiMaxValue > crongMaxValue) {
            return POBI_WIN;
        }

        return CRONG_WIN;
    }

    public static int findMaxValue(List<Integer> pages) {
        int leftPage = 0;
        int rightPage = 0;

        try {
            leftPage = pages.get(LEFT_PAGE_IDX);
            rightPage = pages.get(RIGHT_PAGE_IDX);
        } catch (IndexOutOfBoundsException e) {
            return ERROR;
        }

        if (leftPage != rightPage - 1 || rightPage != leftPage + 1) {
            return ERROR;
        }

        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return ERROR;
        }

        if (leftPage >= rightPage) {
            return ERROR;
        }

        if (leftPage < START_PAGE || rightPage > END_PAGE) {
            return ERROR;
        }

        if (leftPage == START_PAGE || leftPage == END_PAGE - 1) {
            return ERROR;
        }

        if (rightPage == START_PAGE + 1 || rightPage == END_PAGE) {
            return ERROR;
        }

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
