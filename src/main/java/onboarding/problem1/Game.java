package onboarding.problem1;

import java.util.List;

public class Game {
    private static final int USER1_WINNER = 1;
    private static final int USER2_WINNER = 2;
    private static final int DRAW = 0;

    public static int run(List<Integer> user1, List<Integer> user2) {
        if (Validation.check(user1) && Validation.check(user2)) {
            Page user1Page = new Page(user1);
            Page user2Page = new Page(user2);
            List<Integer> user1PossibleValue = Calculate.getPossibleValues(user1Page);
            List<Integer> user2PossibleValue = Calculate.getPossibleValues(user2Page);
            int user1Max = Calculate.getMaxValue(user1PossibleValue);
            int user2Max = Calculate.getMaxValue(user2PossibleValue);
            int winner = getWinner(user1Max, user2Max);
            return winner;
        }
        return Constant.EXCEPTION;
    }
    public static int getWinner(int user_1, int user_2) {
        if (user_1 > user_2) {
            return USER1_WINNER;
        }
        else if (user_1 < user_2) {
            return USER2_WINNER;
        }
        return DRAW;
    }
}
