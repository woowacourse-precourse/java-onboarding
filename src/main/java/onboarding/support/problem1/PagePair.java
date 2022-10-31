package onboarding.support.problem1;

import java.util.List;

public class PagePair {

    private final int leftPage;
    private final int rightPage;
    private final int maxScore;
    private final boolean isValid;

    public PagePair(List<Integer> pages) {
        this.leftPage = pages.get(Constants.getLeftPageIndex());
        this.rightPage = pages.get(Constants.getRightPageIndex());
        this.isValid = isValidPageRange() && isOddPage() && isEvenPage() && checkPagesInterval();

        int leftMaxScore = Math.max(
                calculateDigitSum(leftPage),
                calculateDigitMultiple(leftPage)
        );
        int rightMaxScore = Math.max(
                calculateDigitSum(rightPage),
                calculateDigitMultiple(rightPage)
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
        return rightPage >= Constants.getMinPage() && rightPage <= Constants.getMaxPage()
                && leftPage >= Constants.getMinPage() && leftPage <= Constants.getMaxPage();
    }

    public boolean isOddPage() {
        return leftPage % 2 == Constants.getOddMod();
    }

    public boolean isEvenPage() {
        return rightPage % 2 == Constants.getEvenMod();
    }

    public boolean checkPagesInterval() {
        return rightPage - leftPage == Constants.getPageInterval();
    }

    public boolean isNotValid() {
        return !isValid;
    }

    public int getMaxScore() {
        return maxScore;
    }

}