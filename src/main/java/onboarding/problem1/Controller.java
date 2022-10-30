package onboarding.problem1;

import java.util.List;

public class Controller {
    public static int getSolution(List<Integer> user1, List<Integer> user2) {
        if (Validation.check(user1) && Validation.check(user2)) {
            Page user1Page = new Page(user1);
            Page user2Page = new Page(user2);
            List<Integer> user1PossibleValue = Calculate.getPossibleValues(user1Page);
            List<Integer> user2PossibleValue = Calculate.getPossibleValues(user2Page);
            int user1Max = Calculate.getMaxValue(user1PossibleValue);
            int user2Max = Calculate.getMaxValue(user2PossibleValue);
            int winner = Game.getWinner(user1Max, user2Max);
            return winner;
        }
        return Constant.EXCEPTION;
    }
}
