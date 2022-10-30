package problem7;

import java.util.*;

public class FriendConnection {
    private static final int FRIENDS_SIZE_LOWER_BOUNDS = 1;
    private static final int FRIENDS_SIZE_UPPER_BOUNDS = 10_000;
    private static final int FRIEND_SIZE = 2;
    private static final int VISITORS_SIZE_LOWER_BOUNDS = 0;
    private static final int VISITORS_SIZE_UPPER_BOUNDS = 10_000;
    private static final String ERR_FRIENDS_SIZE = "친구 관계는 1개 이상 10,000개 이하로 입력하세요.";
    private static final String ERR_FRIEND_SIZE = "친구를 이루는 사람이 2명이 아닙니다.";
    private static final String ERR_VISITORS_SIZE = "방문자는 0명 이상 10,000명 이하로 입력하세요.";
    private final Set<String> friends = new HashSet<>();
    private final Map<String, Integer> strangersToRecommendationScore = new HashMap<>();
    private final Map<String, List<String>> friendConnection = new HashMap<>();

    public FriendConnection(String user, List<List<String>> friends) {
        validateFriends(friends);
    }

    private void validateFriends(List<List<String>> friends) {
        if (friends.size() < FRIENDS_SIZE_LOWER_BOUNDS || friends.size() > FRIENDS_SIZE_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_FRIENDS_SIZE);

        for (var friend : friends) {
            if (friend.size() != FRIEND_SIZE)
                throw new IllegalArgumentException(ERR_FRIEND_SIZE);
        }
    }

    private void validateVisitors(List<String> visitors) {
        if (visitors.size() < VISITORS_SIZE_LOWER_BOUNDS || visitors.size() > VISITORS_SIZE_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_VISITORS_SIZE);
    }

    public void calculateRecommendationScore(List<String> visitors) {
        validateVisitors(visitors);
    }

    public List<String> mostRecommendedAsFriend() {
        return null;
    }
}
