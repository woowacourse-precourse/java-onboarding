package onboarding.problem1;

import java.util.List;

public class Controller {
    public static int getSolution(List<Integer> user1, List<Integer> user2) {
        if (Validation.check(user1) && Validation.check(user2)) {
            PageRepository user1Repo = new PageRepository(user1);
            PageRepository user2Repo = new PageRepository(user2);
            int user1Max = user1Repo.BiggestScore();
            int user2Max = user2Repo.BiggestScore();
            int winner = Game.getWinner(user1Max, user2Max);
            return winner;
        }
        return Constant.EXCEPTION;
    }
}
