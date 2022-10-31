package onboarding.problem7;


public class User {
    private String name;
    private int score;

    public User(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public boolean isNotZeroScore() {
        return this.score != 0;
    }

}