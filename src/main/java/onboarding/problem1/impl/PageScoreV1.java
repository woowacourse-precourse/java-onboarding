package onboarding.problem1.impl;

import onboarding.problem1.PageScore;
import onboarding.problem1.PageValidator;

import java.util.List;

public class PageScoreV1 implements PageScore {
    private int leftPage;
    private int rightPage;

    private boolean isValid = true;

    public PageScoreV1(List<Integer> pages) {
        try {
            if (PageValidator.isValid(pages)) {
                this.leftPage = pages.get(0);
                this.rightPage = pages.get(1);
            }
        } catch (Exception e) {
            isValid = false;
        }
    }

    @Override
    public int getScore() {
        if (!isValid) {
            return -1;
        } else {
            return Math.max(calculateOneSideScore(leftPage), calculateOneSideScore(rightPage));
        }
    }

    private int calculateOneSideScore(int pageNumber) {
        return Math.max(sumEachNumber(pageNumber), multipleEachNumber(pageNumber));
    }

    private int sumEachNumber(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber = pageNumber / 10;
        }
        return result;
    }

    private int multipleEachNumber(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber = pageNumber / 10;
        }
        return result;
    }


}
