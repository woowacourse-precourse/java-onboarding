package onboarding.support.problem3;

public class GameUtil {

    private int score;
    private static final int DIGIT_MOD = 10;

    public GameUtil(int number) {
        for (int i = 1; i <= number; i++) {
            this.score += getClapScore(i);
        }
    }

    public static int getClapScore(int number) {
        int clap = 0;
        while (number != 0) {
            if (canGetPoint(number % DIGIT_MOD)) {
                clap++;
            }
            number /= DIGIT_MOD;
        }
        return clap;
    }

    public static boolean canGetPoint(int digit) {
        for (Target target : Target.values()) {
            if (digit == target.getValue()) {
                return true;
            }
        }
        return false;
    }

    public int getScore() {
        return score;
    }
}
