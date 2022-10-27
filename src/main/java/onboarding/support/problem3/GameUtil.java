package onboarding.support.problem3;

public class GameUtil {

    private int score;

    public GameUtil(int number) {
    }

    public static boolean canGetPoint(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }

    public int getScore() {
        return score;
    }
}
