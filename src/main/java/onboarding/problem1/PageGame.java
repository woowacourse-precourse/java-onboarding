package onboarding.problem1;

public class PageGame {
    private static final int FIRST_PLAYER_WIN = 1;
    private static final int SECOND_PLAYER_WIN = 2;
    private static final int DRAW = 0;

    public int play(Page firstPlayerPage, Page secondPlayerPage) {
        int firstPlayerMaxResult = firstPlayerPage.getMaxLeftAndRight();
        int secondPlayerMaxResult = secondPlayerPage.getMaxLeftAndRight();

        return getWinner(firstPlayerMaxResult, secondPlayerMaxResult);
    }

    private static int getWinner(int firstPlayerResult, int secondPlayerResult) {
        if (firstPlayerResult > secondPlayerResult) {
            return FIRST_PLAYER_WIN;
        }
        if (firstPlayerResult < secondPlayerResult) {
            return SECOND_PLAYER_WIN;
        }
        return DRAW;
    }
}
