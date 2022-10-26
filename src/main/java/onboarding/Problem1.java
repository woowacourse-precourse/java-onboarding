package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try {
            Pages pobiPages = new Pages(pobi);
            Pages crongPages = new Pages(crong);

            int pobiMaxResult = pobiPages.getMaxLeftAndRight();
            int crongMaxResult = crongPages.getMaxLeftAndRight();

            return getWinner(pobiMaxResult, crongMaxResult);

        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }

    }

    private static int getWinner(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) {
            return POBI_WIN;
        }
        if (pobiResult < crongResult) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    static class Pages {
        private static final int LEFT_PAGE = 0;
        private static final int RIGHT_PAGE = 1;
        private final List<Integer> pages;

        public Pages(List<Integer> pages) {
            validateIsNotNull(pages);
            validateIsContinuous(pages);
            this.pages = pages;
        }

        private void validateIsNotNull(List<Integer> pages) {
            if (pages.get(LEFT_PAGE) == null || pages.get(RIGHT_PAGE) == null) {
                throw new IllegalArgumentException();
            }
        }

        private void validateIsContinuous(List<Integer> pages) {
            if (pages.get(RIGHT_PAGE) - pages.get(LEFT_PAGE) != 1) {
                throw new IllegalArgumentException();
            }
        }

        private int getMaxLeftAndRight() {
            int leftPageNum = getLeftPageNum(this.pages);
            int rightPageNum = getRightPageNum(this.pages);

            List<Integer> leftPageDigit = splitToDigitList(leftPageNum);
            List<Integer> rightPageDigit = splitToDigitList(rightPageNum);

            int leftPageMax = getMaxSumAndMultiply(leftPageDigit);
            int rightPageMax = getMaxSumAndMultiply(rightPageDigit);

            return Math.max(leftPageMax, rightPageMax);

        }

        private int getLeftPageNum(List<Integer> pages) {
            return pages.get(LEFT_PAGE);
        }

        private int getRightPageNum(List<Integer> pages) {
            return pages.get(RIGHT_PAGE);
        }

        private int getMaxSumAndMultiply(List<Integer> digitList) {

            return Integer.max(getDigitSum(digitList), getDigitMultiply(digitList));
        }

        private List<Integer> splitToDigitList(int number) {

            List<Integer> digitList = new ArrayList<>();
            while (number != 0) {
                digitList.add(number % 10);
                number /= 10;
            }

            return digitList;
        }

        private int getDigitSum(List<Integer> digitList) {

            return digitList.stream().reduce(0, Integer::sum);

        }

        private int getDigitMultiply(List<Integer> digitList) {

            return digitList.stream().reduce(1, (x, y) -> x * y);

        }

    }

}