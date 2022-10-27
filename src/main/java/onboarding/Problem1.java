package onboarding;

import onboarding.problem1.BookGame;
import onboarding.problem1.PageCalculator;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        BookGame bookGame = new BookGame(new PageCalculator());
        return bookGame.doBookGame(pobi, crong);
    }
}