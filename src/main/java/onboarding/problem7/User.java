package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

class User {

    private String name;
    private int score = 0;

    public int getScore() {
        return score;
    }

    public boolean isScoreZero() {
        return score == 0;
    }

    public String getName() {
        return name;
    }

    public void resetScore() {
        score = 0;
    }

    private List<User> friends = new ArrayList<>();

    public void addScore() {
        score++;
    }

    public User(String name) {
        this.name = name;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void calculateFriendsScore(User user) {
        score += countContainedFriends(user) * 10;
    }

    private int countContainedFriends(User src) {
        int count = 0;
        for (var srcFriend : src.friends)
            if (this.friends.contains(srcFriend)) count++;
        return count;
    }

    public boolean isFriend(User user) {
        return friends.contains(user);
    }
}
