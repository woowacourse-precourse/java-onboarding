package onboarding.problem1;

import java.util.List;

public class Controller {
    public static int getSolution(List<Integer> user1, List<Integer> user2) {
        if (Validation.check(user1) && Validation.check(user2)) {
            Page user1Page = new Page(user1);
            Page user2Page = new Page(user2);
            List<Integer> user1PossibleValue = Calculator.getPossibleValues(user1Page);
            List<Integer> user2PossibleValue = Calculator.getPossibleValues(user2Page);
            int user1Max = Calculator.getMaxValue(user1PossibleValue);
            int user2Max = Calculator.getMaxValue(user2PossibleValue);
            int winner = Game.getWinner(user1Max, user2Max);
            return winner;
        }
        return Constant.EXCEPTION;
    }
}
