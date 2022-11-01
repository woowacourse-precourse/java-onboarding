package onboarding;

import onboarding.problem1.Game;
import onboarding.problem1.Page;
import onboarding.problem1.Pages;

import java.util.List;

class Problem1 {

    private static int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Pages pobiPages, crongPages;

        try {
            pobiPages = new Pages(pobi.get(0), pobi.get(1));
            crongPages = new Pages(crong.get(0), crong.get(1));
        } catch (Exception e) {
            return EXCEPTION;
        }

        Game game = new Game(pobiPages, crongPages);

        return game.getWinner();
    }
}