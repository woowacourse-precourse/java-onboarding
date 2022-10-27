package onboarding;

import java.util.List;

import static onboarding.EachDigitCalculator.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageGamePlayer playerPobi, playerCrong;
        PageGame pageGame = new PageGame();

        if(!pageGame.isValid(pobi,crong))
            return -1;

        playerPobi = new PageGamePlayer(pobi);
        playerCrong = new PageGamePlayer(crong);

        return pageGame.winner(playerPobi.maxPageNum(), playerCrong.maxPageNum());
    }
}
