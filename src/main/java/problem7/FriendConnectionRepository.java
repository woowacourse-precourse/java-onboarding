package problem7;

import java.util.*;

public class FriendConnectionRepository {
    private static final Map<String, List<String>> friendConnection = new HashMap<>();

    private FriendConnectionRepository() {}

    public static void create(List<List<String>> friends) {
        Validator.validateFriends(friends);
        friendConnection.clear();
        for (var friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if (!friendConnection.containsKey(friend1)) {
                friendConnection.put(friend1, new ArrayList<>());
            }
            friendConnection.get(friend1).add(friend2);
            if (!friendConnection.containsKey(friend2)) {
                friendConnection.put(friend2, new ArrayList<>());
            }
            friendConnection.get(friend2).add(friend1);
        }
    }

    public static List<String> getFriends(String user) {
        return friendConnection.get(user);
    }



    public static List<String> mostRecommendedAsFriend() {
        return List.of("a");
    }

    private static class Validator {
        private static final int FRIENDS_SIZE_LOWER_BOUNDS = 1;
        private static final int FRIENDS_SIZE_UPPER_BOUNDS = 10_000;
        private static final int FRIEND_SIZE = 2;
        private static final String ERR_FRIENDS_SIZE = "친구 관계는 1개 이상 10,000개 이하로 입력하세요.";
        private static final String ERR_FRIEND_SIZE = "친구를 이루는 사람이 2명이 아닙니다.";
        private static final String ERR_VISITORS_SIZE = "방문자는 0명 이상 10,000명 이하로 입력하세요.";
        public static void validateFriends(List<List<String>> friends) {
            if (friends.size() < FRIENDS_SIZE_LOWER_BOUNDS || friends.size() > FRIENDS_SIZE_UPPER_BOUNDS)
                throw new IllegalArgumentException(ERR_FRIENDS_SIZE);

            for (var friend : friends) {
                if (friend.size() != FRIEND_SIZE)
                    throw new IllegalArgumentException(ERR_FRIEND_SIZE);
            }
        }


    }
}
