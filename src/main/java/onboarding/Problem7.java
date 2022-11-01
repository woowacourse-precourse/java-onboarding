package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int USER_MIN = 1;
    private static final int USER_MAX = 30;
    private static final int FRIENDS_ID_MIN = 1;
    private static final int FRIENDS_ID_MAX = 30;
    private static final int FRIENDS_MIN = 1;
    private static final int FRIENDS_MAX = 10000;
    private static final int VISITOR_MIN = 0;
    private static final int VISITOR_MAX = 10000;
    private static final Map<String, Integer> scoreForUser = new HashMap<>();
    private static final Set<String> userFriends = new HashSet<>();


    public static void updateFinalScore(List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (userFriends.contains(friend.get(0)) || userFriends.contains(friend.get(1))) {
                updateAccumulatedScore(friend.get(0), 10);
                updateAccumulatedScore(friend.get(1), 10);
            }
        }

        for (String visitor : visitors) {
            updateAccumulatedScore(visitor, 1);
        }
    }

    public static void updateAccumulatedScore(String user, int score) {
        scoreForUser.put(user, scoreForUser.getOrDefault(user, 0) + score);
    }

    public static void setFriendsOfUserFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (isFriendsOfUser(friend, user)) {
                userFriends.addAll(friend);
            }
        }
    }

    public static boolean isFriendsOfUser(List<String> friends, String user) {
        return friends.contains(user);
    }

    public static void excludeUserFriends() {
        for (String friend : userFriends) {
            scoreForUser.remove(friend);
        }

    }

    public static void excludeNotValue() {
        for (String key : scoreForUser.keySet()) {
            if (scoreForUser.get(key)==0) {
                scoreForUser.remove(key);
            }
        }
    }

    public static boolean canUser(String user) {
        if(user.length()>=USER_MIN && user.length()<=USER_MAX) return true;
        return false;
    }


}
