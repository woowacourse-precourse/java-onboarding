package onboarding.problem7;

import static onboarding.problem7.Constance.*;

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
        this.score += FRIEND_OF_USER_FRIEND_SCORE;
    }

    public void addVisitsScore() {
        this.score += VISITORS_SCORE;
    }
}
