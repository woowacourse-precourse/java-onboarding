package onboarding;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;
    private Set<String> friends;
    private int score;

    public User(String username) {
        this.username = username;
        this.friends = new HashSet<>();
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getFriends() {
        return friends;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
