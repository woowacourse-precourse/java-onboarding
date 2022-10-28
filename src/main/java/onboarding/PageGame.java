package onboarding;

public class PageGame {
    private static final int DRAW = 0;
    private static final int WINNER_POBI = 1;
    private static final int WINNER_CRONG = 2;

    public static int winner(int pobiNum, int crongNum) {
        if (pobiNum == crongNum)
            return DRAW;

        if (pobiNum > crongNum)
            return WINNER_POBI;

        if (pobiNum < crongNum)
            return WINNER_CRONG;

        return -1;
    }
}
