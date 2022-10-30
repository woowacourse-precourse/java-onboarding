package problem7;

import java.util.*;

/*
친구를 그래프로 표현하기
친구 뽑아내기
person1을 안가지고 있으면 put으로 List<> 넣어라.
person1을 가지고 있든 안 가지고 있든 friendConn.get(person1).add(person2)를 해라
* */
public class FriendConnection {
    private final Map<String, List<String>> friendConnection = new HashMap<>();

    public FriendConnection(List<List<String>> friends) {
        Validator.validateFriends(friends);
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

    public List<String> getFriends(String user) {
        return friendConnection.get(user);
    }

    public void calculateRecommendationScore(List<String> visitors) {
        Validator.validateVisitors(visitors);
    }

    public List<String> mostRecommendedAsFriend() {
        return List.of("a");
    }

    private static class Validator {
        private static final int FRIENDS_SIZE_LOWER_BOUNDS = 1;
        private static final int FRIENDS_SIZE_UPPER_BOUNDS = 10_000;
        private static final int FRIEND_SIZE = 2;
        private static final int VISITORS_SIZE_LOWER_BOUNDS = 0;
        private static final int VISITORS_SIZE_UPPER_BOUNDS = 10_000;
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

        public static void validateVisitors(List<String> visitors) {
            if (visitors.size() < VISITORS_SIZE_LOWER_BOUNDS || visitors.size() > VISITORS_SIZE_UPPER_BOUNDS)
                throw new IllegalArgumentException(ERR_VISITORS_SIZE);
        }
    }
}
