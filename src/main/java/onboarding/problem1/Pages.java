package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Pages {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private final List<Integer> pages;

    public Pages(List<Integer> pages) {
        validateIsNotNull(pages);
        validateIsContinuous(pages);
        validateIsNotEvenAndOdd(pages);
        this.pages = pages;
    }

    private void validateIsNotEvenAndOdd(List<Integer> pages) {
        if (pages.get(LEFT_PAGE) % 2 != 1 || pages.get(RIGHT_PAGE) % 2 != 0) {
            throw new IllegalArgumentException();
        }
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

    public int getMaxLeftAndRight() {
        int leftPageNum = getLeftPageNum();
        int rightPageNum = getRightPageNum();

        List<Integer> leftPageDigit = splitToDigitList(leftPageNum);
        List<Integer> rightPageDigit = splitToDigitList(rightPageNum);

        int leftPageMax = getMaxSumAndMultiply(leftPageDigit);
        int rightPageMax = getMaxSumAndMultiply(rightPageDigit);

        return Math.max(leftPageMax, rightPageMax);

    }

    private Integer getLeftPageNum() {
        return pages.get(LEFT_PAGE);
    }

    private Integer getRightPageNum() {
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

