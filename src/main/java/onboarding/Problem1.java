package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageGamePlayer playerPobi, playerCrong;

        playerPobi = new PageGamePlayer(pobi);
        playerCrong = new PageGamePlayer(crong);

        if (!playerCrong.isValid() || !playerPobi.isValid())
            return -1;

        return PageGame.winner(playerPobi.maxPageNum(), playerCrong.maxPageNum());
    }
}
