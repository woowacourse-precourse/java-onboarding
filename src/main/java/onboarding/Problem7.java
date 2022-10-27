package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, User> users = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        users.put(user, new User(user));

        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            users.put(userA, users.getOrDefault(userA, new User(userA)));
            users.put(userB, users.getOrDefault(userB, new User(userB)));
            if (userB.equals(user)) {
                users.get(user).addFriend(users.get(userA));
                continue;
            }
            users.get(userA).addFriend(users.get(userB));
        }

        return answer;
    }

    static class User {
        String id;
        List<User> friends = new ArrayList<>();

        public User(String id) {
            this.id = id;
        }

        public void addFriend(User user) {
            friends.add(user);
        }
    }
}
