package problem7;

import java.util.*;

public class FriendConnectionRepository {
    private static final Map<String, Set<String>> friendConnection = new HashMap<>();

    private FriendConnectionRepository() {}

    public static void create(List<List<String>> friends) {
        Validator.validateFriends(friends);

        friendConnection.clear();

        preprocessFriendConnection(friends);

        configureFriendConnection(friends);
    }

    private static void preprocessFriendConnection(List<List<String>> friends) {
        friends.stream()
                .flatMap(friendship -> friendship.stream())
                .distinct()
                .filter(person -> !friendConnection.containsKey(person))
                .forEach(person -> friendConnection.put(person, new HashSet<>()));
    }

    private static void configureFriendConnection(List<List<String>> friends) {
        friends.stream()
                .forEach(friend -> {
                    var first = friend.get(0);
                    var second = friend.get(1);

                    friendConnection.get(first).add(second);
                    friendConnection.get(second).add(first);
                });
    }

    public static Set<String> getFriends(String user) {
        return friendConnection.get(user);
    }

    private static class Validator {
        private static final int FRIENDS_SIZE_LOWER_BOUNDS = 1;
        private static final int FRIENDS_SIZE_UPPER_BOUNDS = 10_000;
        private static final int FRIEND_SIZE = 2;
        private static final String ERR_FRIENDS_SIZE = "친구 관계는 1개 이상 10,000개 이하로 입력하세요.";
        private static final String ERR_FRIEND_SIZE = "친구를 이루는 사람이 2명이 아닙니다.";
        private static final String ERR_SELF_FRIEND = "친구 관계에 동일한 이름이 들어갈 수 없습니다.";

        public static void validateFriends(List<List<String>> friends) {
            if (friends.size() < FRIENDS_SIZE_LOWER_BOUNDS || friends.size() > FRIENDS_SIZE_UPPER_BOUNDS)
                throw new IllegalArgumentException(ERR_FRIENDS_SIZE);

            for (var friend : friends) {
                if (friend.size() != FRIEND_SIZE)
                    throw new IllegalArgumentException(ERR_FRIEND_SIZE);
                if (Objects.equals(friend.get(0), friend.get(1)))
                    throw new IllegalArgumentException(ERR_SELF_FRIEND);
            }
        }


    }
}
