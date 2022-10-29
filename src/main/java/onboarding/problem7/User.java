package onboarding.problem7;

public class User {

    private final String name;
    private int score = 0;

    public static User createUser(String name) {
        return new User(name);
    }

    private User(String name) {
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
