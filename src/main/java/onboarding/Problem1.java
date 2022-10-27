package onboarding;

import onboarding.support.problem1.PagePair;
import onboarding.support.problem1.Winner;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        PagePair pobiPagePair = new PagePair(pobi);
        PagePair crongPagePair = new PagePair(crong);

        if (preConditions(pobiPagePair, crongPagePair)) {
            return Winner.EXCEPTION.getResult();
        }

        answer = getAnswer(pobiPagePair.getMaxScore(), crongPagePair.getMaxScore());

        return answer;
    }

    private static boolean preConditions(PagePair pobiPagePair, PagePair crongPagePair) {
        return pobiPagePair.isNotValid() || crongPagePair.isNotValid();
    }

    public static int getAnswer(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return Winner.POBI.getResult();
        }
        if (pobiScore < crongScore) {
            return Winner.CRONG.getResult();
        }
        return Winner.TIE.getResult();
    }
}