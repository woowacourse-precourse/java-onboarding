package onboarding.problem7;

public class Friend {
    private String name;
    private int score = 0;

    public Friend(String name) {
        this.name = name;
    }

    public Friend addScore(int score) {
        this.score += score;
        return this;
    }
}
