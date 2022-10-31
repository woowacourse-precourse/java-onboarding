package onboarding.prob1.domain;

import java.util.List;

public class BookGame {
    public int solve(final List<Integer> pobi, final List<Integer> crong) {
        return getResult(pobi, crong);
    }

    private static int getResult(final List<Integer> pobi, final List<Integer> crong) {
        try {
            Player player1 = new Player(Pages.of(pobi));
            Player player2 = new Player(Pages.of(crong));
            return getWinner(player1, player2);
        } catch (Exception e) {
            return -1;
        }
    }

    static int getWinner(Player pobi, Player crong) {
        Integer pobiScore = pobi.getScore();
        Integer crongScore = crong.getScore();
        int i = pobiScore.compareTo(crongScore);
        if (i == 0) return 0;
        if (i > 0) return 1;
        if (i < 0) return 2;
        return -1;
    }
}
