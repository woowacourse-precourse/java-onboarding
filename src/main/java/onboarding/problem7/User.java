package onboarding.problem7;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class User implements Comparable<User> {
    private String nickname;

    private Set<User> friends = new HashSet<>();
    private int score;

    public User(String nickname) {
        this.nickname = nickname;
        this.score = 0;
    }

    public void addFriend(User friend) {
        this.friends.add(friend);
    }

    public boolean isFriendOf(User friend) {
        return friends.contains(friend);
    }

    public void addScore(int score) {
        this.score += score;
    }

    public String getNickname() {
        return nickname;
    }
    public Set<User> getFriends() {
        return friends;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(User o) {
        if (this.getScore() == o.getScore()) {
            return this.getNickname().compareTo(o.getNickname());
        }

        return o.getScore() - this.getScore();
    }
}
