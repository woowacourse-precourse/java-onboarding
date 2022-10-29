package onboarding.problem3;

public class Game {
    private static final char THREE = '3';
    private static final char SIX = '6';
    private static final char NINE = '9';

    private static int getDigitClap(char digit) {
        int clap = 0;
        if((digit == THREE) || (digit == SIX) || (digit == NINE)){
            clap = 1;
        }
        return clap;
    }
}
