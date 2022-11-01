package onboarding.problem3;

public class Game {
    private static final char THREE = '3';
    private static final char SIX = '6';
    private static final char NINE = '9';

    public static int playGame(int number) {
        int clap = 0;
        for (int gameNumber = 1; gameNumber <= number; gameNumber++) {
            clap += getNumberClap(gameNumber);
        }
        return clap;
    }

    private static int getDigitClap(char digit) {
        int clap = 0;
        if ((digit == THREE) || (digit == SIX) || (digit == NINE)) {
            clap = 1;
        }
        return clap;
    }

    private static int getNumberClap(int number) {
        String numberStr = String.valueOf(number);
        int clap = 0;
        for (int idx = 0; idx < numberStr.length(); idx++) {
            clap += getDigitClap(numberStr.charAt(idx));
        }
        return clap;
    }
}
