package onboarding;

import java.util.*;

public class Problem7 {
    private static final int RELATED_POINT = 10;
    private static final int VISITOR_POINT = 1;

    static Map<String, User> users = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<User> recommendedFriends = new HashSet<>();

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

        for (User friend : users.get(user).friends) {
            for (User relatedFriend : friend.friends) {
                recommendedFriends.add(relatedFriend);
                relatedFriend.plusPoint(RELATED_POINT);
            }
        }

        return answer;
    }

    static class User {
        String id;
        int point;
        List<User> friends = new ArrayList<>();

        public User(String id) {
            this.id = id;
            this.point = 0;
        }

        public void addFriend(User user) {
            friends.add(user);
        }

        public void plusPoint(int point) {
            this.point += point;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", point=" + point +
                    ", friends=" + friends +
                    '}';
        }
    }
}
