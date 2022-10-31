package onboarding.problem1;

public class Game {
    private static final int USER1_WINNER = 1;
    private static final int USER2_WINNER = 2;
    private static final int DRAW = 0;

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
