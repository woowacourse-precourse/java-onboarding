package onboarding.problem7;

public class User {

    private String name;
    private int score = 0;

    public User(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public void addFriendScore() {
        this.score += 10;
    }

    public void addVisitsScore() {
        this.score += 1;
    }
}
