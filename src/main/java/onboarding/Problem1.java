package onboarding;

import onboarding.problem1.Page;
import onboarding.problem1.PageGame;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Page pobiPage = new Page(pobi);
            Page crongPage = new Page(crong);

            PageGame pageGame = new PageGame();

            return pageGame.getGameWinner(pobiPage, crongPage);

        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }

    }




}