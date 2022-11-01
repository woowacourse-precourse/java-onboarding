package onboarding;

import java.util.List;
import onboarding.problem1.PageGame;

class Problem1 {
    private static final Integer EXCEPTION_NUMBER = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try {

            int pobiMaxScore = PageGame.getMaxScore(pobi);
            int crongMaxScore = PageGame.getMaxScore(crong);

            return PageGame.getPageNumberGameResult(pobiMaxScore, crongMaxScore);

        } catch (Error e) {
            return EXCEPTION_NUMBER;
        }
    }
}