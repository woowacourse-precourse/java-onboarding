package onboarding.problem7;

public class Friend {
    private final String NAME;
    private int score = 0;

    public Friend(String name) {
        this.NAME = name;
    }

    public Friend addScore(int score) {
        this.score += score;
        return this;
    }

    public String getName() {
        return NAME;
    }

    public int getScore() {
        return score;
    }
}
