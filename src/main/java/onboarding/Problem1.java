package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageGamePlayer playerPobi, playerCrong;

        playerPobi = new PageGamePlayer(pobi);
        playerCrong = new PageGamePlayer(crong);

        return PageGame.winner(playerPobi.maxPageNum(), playerCrong.maxPageNum());
    }
}
