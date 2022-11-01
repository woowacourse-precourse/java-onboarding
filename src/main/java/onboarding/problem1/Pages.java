package onboarding.problem1;

import java.util.List;

import static onboarding.problem1.ConstantsP1.FIRST_PAGE;
import static onboarding.problem1.ConstantsP1.LAST_PAGE;

public class Pages {
    private static final boolean ILLEGAL = true;
    private static final boolean LEGAL = false;
    private final List<Integer> pageList;

    public Pages(List<Integer> pageList) {
        this.pageList = pageList;
    }

    public boolean isIllegal() {
        try {
            isNotNull();
            isLengthOfTwo();
            isOddAndEven();
            isConsecutive();
            isInRange();
            isNotEndOrBeginning();
            return LEGAL;
        } catch (IllegalArgumentException e) {
            return ILLEGAL;
        }
    }

    private void isNotNull() {
        if (pageList == null) {
            throw new IllegalArgumentException();
        }
    }

    private void isLengthOfTwo() {
        if (pageList.size() != 2) {
            throw new IllegalArgumentException();
        }
        if (pageList.get(0) == null) {
            throw new IllegalArgumentException();
        }
        if (pageList.get(1) == null) {
            throw new IllegalArgumentException();
        }
    }

    private void isOddAndEven() {
        if (pageList.get(0) % 2 != 1) {
            throw new IllegalArgumentException();
        }
        if (pageList.get(1) % 2 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void isConsecutive() {
        if ((pageList.get(1) - pageList.get(0)) != 1) {
            throw new IllegalArgumentException();
        }
    }

    private void isInRange() {
        if (pageList.get(0) < FIRST_PAGE || pageList.get(0) > LAST_PAGE) {
            throw new IllegalArgumentException();
        }
        if (pageList.get(1) < FIRST_PAGE || pageList.get(1) > LAST_PAGE) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotEndOrBeginning() {
        if (pageList.get(0) == FIRST_PAGE) {
            throw new IllegalArgumentException();
        }
        if (pageList.get(1) == LAST_PAGE) {
            throw new IllegalArgumentException();
        }
    }

    public int getLeftPage() {
        return pageList.get(0);
    }

    public int getRightPage() {
        return pageList.get(1);
    }
}
