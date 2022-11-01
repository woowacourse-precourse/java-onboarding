package onboarding;

import java.util.*;

public class Problem7 {
    private static final Map<String, Integer> scoreMap = new HashMap<>();
    private static final Set<String> friendsOfUserSet = new HashSet<>();
    private static final int SHARE_POINT = 10;
    private static final int VISIT_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setFriends(friends, user);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void updateScore(List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (friendsOfUserSet.contains(friend.get(0)) || friendsOfUserSet.contains(friend.get(1))) {
                giveScore(friend.get(0), SHARE_POINT);
                giveScore(friend.get(1), SHARE_POINT);
            }
        }
        for (String visitor : visitors) {
            giveScore(visitor, VISIT_POINT);
        }
    }

    public static void giveScore(String user, int score) {
        scoreMap.put(user, scoreMap.getOrDefault(user, 0) + score);
    }

    public static void setFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (isFriendOfUser(friend, user)) {
                friendsOfUserSet.addAll(friend);
            }
        }
    }

    public static boolean isFriendOfUser(List<String> friend, String user) {
        return friend.contains(user);
    }
}
