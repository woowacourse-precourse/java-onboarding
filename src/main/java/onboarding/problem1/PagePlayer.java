package onboarding.problem1;

public class PagePlayer {
    private static final int DRAW = 0;
    private static final int WIN = 1;
    private static final int LOOSE = 2;

    private Pages pages;
    private int score;

    public PagePlayer(Pages pages) {
        this.pages = pages;
        this.score = pages.calculateScore();
    }

    public int getScore() {
        return this.score;
    }

    public int compareScore(PagePlayer other) {
        if (this.score == other.getScore())
            return DRAW;
        if (this.score < other.getScore()) {
            return LOOSE;
        }
        return WIN;
    }
}
