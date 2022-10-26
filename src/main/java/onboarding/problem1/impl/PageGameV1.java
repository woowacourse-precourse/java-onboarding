package onboarding.problem1.impl;

import onboarding.problem1.PageGame;
import onboarding.problem1.PageScore;

import java.util.List;

public class PageGameV1 implements PageGame {
    private final PageScore pobiScore;
    private final PageScore crongScore;

    public PageGameV1(PageScore pobiScore, PageScore crongScore) {
        this.pobiScore = pobiScore;
        this.crongScore = crongScore;
    }

    @Override
    public int getResult() {
        int pobiCalculatedScore = pobiScore.getScore();
        int crongCalculatedScore = crongScore.getScore();

        if (pobiCalculatedScore == -1 || crongCalculatedScore == -1) {
            return -1;
        } else if (pobiCalculatedScore == crongCalculatedScore) {
            return 0;
        } else if (pobiCalculatedScore > crongCalculatedScore) {
            return 1;
        } else {
            return 2;
        }
    }


}
