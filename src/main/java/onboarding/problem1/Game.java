package onboarding.problem1;

import java.util.List;

public class Game {
    private static final int USER1_WINNER = 1;
    private static final int USER2_WINNER = 2;
    private static final int DRAW = 0;

    public static int run(List<Integer> user_1, List<Integer> user_2) {
        if (Validation.check(user_1) && Validation.check(user_2)) {
            int user1Max = Calculate.getMaxValue(user_1);
            int user2Max = Calculate.getMaxValue(user_2);
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
