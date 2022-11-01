package onboarding.problem7;

import java.util.*;

public class Users {

    private final int CO_FRIEND_SCORE = 10;

    private final List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    private void getCoFriendScore(User user, Map<User, Integer> scoreMap) {
        for (User candidate : users) {
            if (candidate.equals(user)) continue;
            scoreMap.put(candidate, candidate.countCoFriends(user) * CO_FRIEND_SCORE);
        }
    }
}