package onboarding.problem1;

public class Game {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;

    private Pages pages1;
    private Pages pages2;

    public Game(Pages pages1, Pages pages2) {
        this.pages1 = pages1;
        this.pages2 = pages2;
    }

    public int getWinner() {
        int score1 = pages1.getScore();
        int score2 = pages2.getScore();

        if (score1 > score2) {
            return POBI_WIN;
        } else if (score1 < score2) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }
}
