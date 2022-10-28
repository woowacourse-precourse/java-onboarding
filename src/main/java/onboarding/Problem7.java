package onboarding;

import java.util.*;

public class Problem7 {
    private static final Map<String, Integer> userAndScoreMap = new HashMap<>();
    private static final Set<String> myFriendsSet = new HashSet<>();
    private static final int ACQUAINTANCE_POINT = 10;
    private static final int VISITOR_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void removeMyFriendsAndValueIsZero() {
        for (String friend : myFriendsSet) {
            userAndScoreMap.remove(friend);
        }

        for (String key : userAndScoreMap.keySet()) {
            if (userAndScoreMap.get(key) == 0) {
                userAndScoreMap.remove(key);
            }
        }
    }

    public static void updateScore(List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (myFriendsSet.contains(friend.get(0)) || myFriendsSet.contains(friend.get(1))) {
                updateRecommendScore(friend.get(0), ACQUAINTANCE_POINT);
                updateRecommendScore(friend.get(1), ACQUAINTANCE_POINT);
            }
        }
        for (String visitor : visitors) {
            updateRecommendScore(visitor, VISITOR_POINT);
        }
    }

    public static void updateRecommendScore(String user, int score) {
        userAndScoreMap.put(user, userAndScoreMap.getOrDefault(user, 0) + score);
    }

    public static void friendsSetup(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (isFriendsContainUser(friend, user)) {
                myFriendsSet.addAll(friend);
            }
        }
    }

    public static boolean isFriendsContainUser(List<String> friends, String user) {
        return friends.contains(user);
    }
}
