package onboarding;

import java.util.*;

public class Problem7 {
    private static final int USER = 0;
    private static final int FRIEND = 1;

    public static class User {
        private String id;
        private int score;
        private List<String> friends;

        public User(String id) {
            this.id = id;
            this.score = 0;
            this.friends = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public void addFriend(String friend) {
            this.friends.add(friend);
        }

        public List<String> getFriends() {
            return friends;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Map<String, User> setFriends(List<List<String>> friends, String user) {
        Map<String, User> users = new HashMap<>();
        users.put(user, new User(user));

        for (List<String> friend : friends) {
            String userId = friend.get(USER);
            String friendId = friend.get(FRIEND);

            addFriendOfUser(users, userId, friendId);
            addFriendOfUser(users, friendId, userId);
        }

        return users;
    }

    private static void addFriendOfUser(Map<String, User> users, String userId, String friendId) {
        User user = users.getOrDefault(userId, new User(userId));
        user.addFriend(friendId);
        users.put(userId, user);
    }
}
