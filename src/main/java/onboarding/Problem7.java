package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    private static final int USER_RELATED_POINT = 10;
    private static final int FRIEND_A = 0;
    private static final int FRIEND_B = 1;

    private static List<String> userFriends = new ArrayList<>();
    private static Map<String, User> relationShips = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriends.clear();
        relationShips.clear();
        relationShips.put(user, new User(user));

        reflectAlreadyUserFriends(user, friends);
        reflectFriendsRelated(friends, user);
    }

    private static void reflectAlreadyUserFriends(String user, List<List<String>> friends) {
        friends.forEach(friend -> addUserFriend(user, friend.get(FRIEND_A), friend.get(FRIEND_B)));
    }

    private static void addUserFriend(String userName, String friendAName, String friendBName) {
        if (friendAName.equals(userName)) {
            userFriends.add(friendBName);
        }
        if (friendBName.equals(userName)) {
            userFriends.add(friendAName);
        }
    }

    private static void reflectFriendsRelated(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            handleRelatedFriend(user, friend);
        }
    }

    private static void handleRelatedFriend(String user, List<String> friend) {
        String friendAName = friend.get(FRIEND_A);
        String friendBName = friend.get(FRIEND_B);
        if (userFriends.contains(friendAName)) {
            User friendB = relationShips.getOrDefault(friendBName, new User(friendBName));
            relationShips.put(friendBName, friendB);
            relationShips.get(user).reflectFriend(friendB);
        }
        if (userFriends.contains(friendBName)) {
            User friendA = relationShips.getOrDefault(friendAName, new User(friendAName));
            relationShips.put(friendAName, friendA);
            relationShips.get(user).reflectFriend(friendA);
        }
    }

    static class User implements Comparable<User> {

        private final String name;
        private int recommendPoint;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void reflectFriend(User friend) {
            friend.increaseRelatedFriendPoint();
        }

        public void increaseRelatedFriendPoint() {
            this.recommendPoint += USER_RELATED_POINT;
        }

        @Override
        public int compareTo(User user) {
            if (this.recommendPoint == user.recommendPoint) {
                return this.name.compareTo(user.name);
            }
            return Integer.compare(user.recommendPoint, this.recommendPoint);
        }
    }
}
