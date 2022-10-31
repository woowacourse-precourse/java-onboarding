package onboarding.support.problem1;

import java.util.List;

public class PagePair {

    private final int leftPageNumber;
    private final int rightPageNumber;
    private final int maxScore;
    private final boolean isValid;

    public PagePair(List<Integer> pages) {
        this.leftPageNumber = pages.get(Constants.getLeftPageIndex());
        this.rightPageNumber = pages.get(Constants.getRightPageIndex());
        this.isValid = isValidPageRange() && isOddPage() && isEvenPage() && checkPagesInterval();

        int leftMaxScore = Math.max(
                calculateDigitSum(leftPageNumber),
                calculateDigitMultiple(leftPageNumber)
        );
        int rightMaxScore = Math.max(
                calculateDigitSum(rightPageNumber),
                calculateDigitMultiple(rightPageNumber)
        );

        this.maxScore = Math.max(leftMaxScore, rightMaxScore);
    }

    public int calculateDigitSum(int pageNumber) {
        int digitSum = 0;
        while (pageNumber >= Constants.getMinPage()) {
            digitSum += pageNumber % Constants.getDigitMod();
            pageNumber /= Constants.getDigitMod();
        }
        return digitSum;
    }

    public int calculateDigitMultiple(int pageNumber) {
        int digitMultiple = 1;
        while (pageNumber >= Constants.getMinPage()) {
            digitMultiple *= pageNumber % Constants.getDigitMod();
            pageNumber /= Constants.getDigitMod();
        }
        return digitMultiple;
    }

    public boolean isValidPageRange() {
        return rightPageNumber >= Constants.getMinPage() && rightPageNumber <= Constants.getMaxPage()
                && leftPageNumber >= Constants.getMinPage() && leftPageNumber <= Constants.getMaxPage();
    }

    public boolean isOddPage() {
        return leftPageNumber % 2 == Constants.getOddMod();
    }

    public boolean isEvenPage() {
        return rightPageNumber % 2 == Constants.getEvenMod();
    }

    public boolean checkPagesInterval() {
        return rightPageNumber - leftPageNumber == Constants.getPageInterval();
    }

    public boolean isNotValid() {
        return !isValid;
    }

    public int getMaxScore() {
        return maxScore;
    }

}