package onboarding.support.problem1;

import java.util.List;

public class PagePair {

    private final int leftPage;
    private final int rightPage;
    private final int maxScore;
    private final boolean isValid;

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
        while (pageNumber != Constants.getMinPage()) {
            digitMultiple *= pageNumber % Constants.getDigitMod();
            pageNumber /= Constants.getDigitMod();
        }
        return digitMultiple;
    }

    public boolean isNotValid() {
        return !isValid;
    }

    public int getMaxScore() {
        return maxScore;
    }

}