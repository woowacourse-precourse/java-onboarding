package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {

    private static Map<String, User> userRepository = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            User userA = userRepository.getOrDefault(friendA, new User(friendA));
            User userB = userRepository.getOrDefault(friendB, new User(friendB));

            userA.addFriend(userB);
            userB.addFriend(userA);
        }

        User mainUser = userRepository.get(user);

        return answer;
    }
}

class User {
    private String userId;

    private Set<User> friends = new HashSet<>();
    private int score;

    public User(String userId) {
        this.userId = userId;
        this.score = 0;
    }

    public void addFriend(User friend) {
        this.friends.add(friend);
    }

    public String getUserId() {
        return userId;
    }
    public Set<User> getFriends() {
        return friends;
    }

    public int getScore() {
        return score;
    }
}
