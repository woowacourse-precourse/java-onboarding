package problem1;

import java.util.List;

public class Player {

    public static final int INIT_SUM_VALUE = 0;
    public static final int INIT_MULTIPLE_VALUE = 1;
    public static final int DIVIDE_CRITERION = 10;
    public static final int NUMBER_LOOP_CRITERION = 0;
    public static final int LEFT_PAGE_INDEX = 0;
    public static final int RIGHT_PAGE_INDEX = 1;

    private final List<Integer> pages;

    public Player(List<Integer> pages) {
        this.pages = pages;
    }

    public int addDigitNumber(int number) {
        int sum = INIT_SUM_VALUE;
        while (number != NUMBER_LOOP_CRITERION) {
            sum += number % DIVIDE_CRITERION;
            number /= DIVIDE_CRITERION;
        }

        return sum;
    }

    public int multipleDigitNumber(int number) {
        int result = INIT_MULTIPLE_VALUE;
        while (number != NUMBER_LOOP_CRITERION) {
            result *= number % DIVIDE_CRITERION;
            number /= DIVIDE_CRITERION;
        }

        return result;
    }

    public int calculateMaxNumber(int number, int compareNumber) {
        return Math.max(number, compareNumber);
    }

    public int calculateLeftMaxNumber() {
        return calculatePageMaxNumber(LEFT_PAGE_INDEX);
    }

    public int calculateRightMaxNumber() {
        return calculatePageMaxNumber(RIGHT_PAGE_INDEX);
    }

    private int calculatePageMaxNumber(int pageIndex) {
        return calculateMaxNumber(addDigitNumber(pages.get(pageIndex))
                , multipleDigitNumber(pages.get(pageIndex)));
    }

    public int calculateTotalScore() {
        return calculateMaxNumber(calculateLeftMaxNumber(), calculateRightMaxNumber());
    }
}
