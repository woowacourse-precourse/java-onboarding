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

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if(!canUser(user) && !canVisitors(visitors) && !canFriends(friends)) {
            throw new IllegalArgumentException("제한 사항을 위반하였습니다.");
        }

        setFriendsOfUserFriends(friends, user);
        updateFinalScore(friends, visitors);
        excludeUserFriends();
        excludeNotValue();

        List<String> answer = scoreForUser.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());

        return answer;
    }

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

    public static boolean canFriends(List<List<String>> friends) {
        if(friends.size()>=FRIENDS_MIN && friends.size()<=FRIENDS_MAX && friends.get(0).toString().length()>=FRIENDS_ID_MIN &&
                friends.get(1).toString().length()<=FRIENDS_ID_MAX) return true;
        return false;
    }

    public static boolean canVisitors(List<String> visitors) {
        for(String visitor : visitors) {
            if(visitor.length()>=VISITOR_MIN && visitor.length()<=VISITOR_MAX) return true;
        }
        return false;
    }


}
