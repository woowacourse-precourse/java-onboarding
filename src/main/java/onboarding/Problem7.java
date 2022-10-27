package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int CO_FRIEND_SCORE = 10;
    private static final int VISITED_SCORE = 1;
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

            userRepository.put(userA.getUserId(), userA);
            userRepository.put(userB.getUserId(), userB);
        }

        User mainUser = userRepository.get(user);
        for (User friend : userRepository.values()) {
            if (!friend.isFriendOf(mainUser)) {

                //FIXME : depth가 깊음
                for (User friendOfFriend : friend.getFriends()) {
                    if (friendOfFriend.isFriendOf(mainUser)) {
                        friend.addScore(CO_FRIEND_SCORE);
                    }
                }
            }
        }

        for (String visitor : visitors) {
            User visitedUser = userRepository.getOrDefault(visitor, new User(visitor));
            visitedUser.addScore(VISITED_SCORE);

            userRepository.put(visitedUser.getUserId(), visitedUser);
        }

        answer = userRepository.values().stream()
            .filter(u -> !u.isFriendOf(mainUser))
            .filter(u -> !u.getUserId().equals(user))
            .filter(u -> u.getScore() > 0)
            .sorted(new Comparator<User>() {
                @Override
                public int compare(User user1, User user2) {
                    if (user1.getScore() == user2.getScore()) {
                        return user1.getUserId().compareTo(user2.getUserId());
                    }

                    return user2.getScore() - user1.getScore();
                }
            })
            .map(User::getUserId)
            .collect(Collectors.toList());

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

    public boolean isFriendOf(User friend) {
        return friends.contains(friend);
    }

    public void addScore(int score) {
        this.score += score;
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
