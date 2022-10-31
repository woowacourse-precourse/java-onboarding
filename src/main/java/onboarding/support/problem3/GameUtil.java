package onboarding.support.problem3;

public class GameUtil {

    private int score;
    private static final int MOD = 10;

    public GameUtil(int number) {
        for (int i = 1; i <= number; i++) {
            this.score += getClapCount(i);
        }
    }

    public static int getClapCount(int number) {
        int clap = 0;
        while (number != 0) {
            if (canGetPoint(number % MOD)) {
                clap++;
            }
            number /= MOD;
        }
        return clap;
    }

    public static boolean canGetPoint(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }

    public int getScore() {
        return score;
    }
}
