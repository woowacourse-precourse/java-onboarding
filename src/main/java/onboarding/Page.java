package onboarding;

import java.util.Arrays;
import java.util.List;

public class Page {
    private final int leftPageNumber;
    private final int rightPageNumber;
    private int maxValue;
    private String maxValueUser;

    public Page(List<Integer> list) {
        this.leftPageNumber = list.get(0);
        this.rightPageNumber = list.get(1);
        this.maxValue = 0;
    }

    public int getLeftPageNumber() {
        return leftPageNumber;
    }

    public int getRightPageNumber() {
        return rightPageNumber;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public String getMaxValueUser() {
        return maxValueUser;
    }

    public Page findMaxValue(String userName) {
        this.maxValueUser = userName;
        return getPageWithMaxValue();
    }

    private Page getPageWithMaxValue() {
        int leftMaxValue = compareNumberPerPageSumTimes(leftPageNumber);
        int rightMaxValue = compareNumberPerPageSumTimes(rightPageNumber);

        if (leftMaxValue > rightMaxValue) {
            this.maxValue = leftMaxValue;
            return this;
        }
        this.maxValue = rightMaxValue;
        return this;
    }

    public int compareNumberPerPageSumTimes(int side) {
        int numberPerPageSum = getNumberPerPageSum(side);
        int numberPerPageTimes = getNumberPerPageTimes(side);
        if (numberPerPageTimes > numberPerPageSum) {
            return numberPerPageTimes;
        }
        return numberPerPageSum;
    }

    private int getNumberPerPageSum(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::valueOf)
                .reduce(0, Integer::sum);
    }

    private int getNumberPerPageTimes(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::valueOf)
                .reduce(1, (a, b) -> a * b);
    }

    public boolean validationCheck() {
        if (oddEvenCheck()) return false;
        if (outOfRangeLeftCheck()) return false;
        if (outOfRangeRightCheck()) return false;
        if (differenceCheck()) return false;
        if (firstPageLastPageCheck()) return false;
        return true;
    }

    private boolean firstPageLastPageCheck() {
        if ((this.leftPageNumber == 1) || (this.rightPageNumber == 400)) {
            return true;
        }
        return false;
    }

    private boolean differenceCheck() {
        if ((this.rightPageNumber - this.leftPageNumber) != 1) {
            return true;
        }
        return false;
    }

    private boolean outOfRangeRightCheck() {
        if ((rightPageNumber < 2) || (rightPageNumber > 401)) {
            return true;
        }
        return false;
    }

    private boolean outOfRangeLeftCheck() {
        if ((leftPageNumber < 1) || (leftPageNumber > 400)) {
            return true;
        }
        return false;
    }

    private boolean oddEvenCheck() {

        if (((leftPageNumber % 2) == 0) || ((rightPageNumber % 2) == 1)) {
            return true;
        }
        return false;
    }
}
