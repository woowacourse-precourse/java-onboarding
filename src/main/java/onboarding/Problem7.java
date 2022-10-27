package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static List<String> userFriends = new ArrayList<>();
    private static Map<String, Integer> friendPoints = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        getUserFriends(user, friends);
        getFriendPoint(user, friends);
        getVisitorPoints(visitors);
        return getRecommendation();
    }

    private static void getUserFriends(String user, List<List<String>> friends) {
        for (List<String> friendship : friends) {
            if (friendship.get(0) == user) {
                userFriends.add(friendship.get(1));
            } else if (friendship.get(1) == user) {
                userFriends.add(friendship.get(0));
            }
        }
    }

    private static void getFriendPoint(String user, List<List<String>> friends) {
        for (List<String> friendship : friends) {
            String leftFriend = friendship.get(0);
            String rightFriend = friendship.get(1);
            if (friendship.contains(user)) {
                continue;
            } else if (userFriends.contains(leftFriend)) {
                friendPoints.put(rightFriend, friendPoints.getOrDefault(rightFriend, 10) + 10);
            } else if (userFriends.contains(rightFriend)) {
                friendPoints.put(leftFriend, friendPoints.getOrDefault(leftFriend, 10) + 10);
            }
        }
    }

    private static void getVisitorPoints(List<String> visitors) {
        for (String visitor : visitors) {
            friendPoints.put(visitor, friendPoints.getOrDefault(visitor, 1) + 1);
        }
    }

    private static List<String> getRecommendation() {
        return friendPoints.entrySet().stream()
                .filter(friend -> !userFriends.contains(friend.getKey()) && friendPoints.get(friend.getKey()) > 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toUnmodifiableList());
    }
}
