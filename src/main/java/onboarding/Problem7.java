package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendPoints = new HashMap<>();

        List<String> userFriends = getUserFriends(user, friends);
        getFriendPoint(friends, friendPoints, userFriends);
        getVisitorPoints(visitors, friendPoints);
        return getRecommendation(friendPoints, userFriends, user);
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friendship : friends) {
            if (friendship.get(0) == user) {
                userFriends.add(friendship.get(1));
            } else if (friendship.get(1) == user) {
                userFriends.add(friendship.get(0));
            }
        }
        return userFriends;
    }

    private static void getFriendPoint(List<List<String>> friends, Map<String, Integer> friendPoints, List<String> userFriends) {
        for (List<String> friendship : friends) {
            String leftFriend = friendship.get(0);
            String rightFriend = friendship.get(1);
            if (userFriends.contains(leftFriend)) {
                friendPoints.put(rightFriend, friendPoints.getOrDefault(rightFriend, 10) + 10);
            } else if (userFriends.contains(rightFriend)) {
                friendPoints.put(leftFriend, friendPoints.getOrDefault(leftFriend, 10) + 10);
            }
        }
    }

    private static void getVisitorPoints(List<String> visitors, Map<String, Integer> friendPoints) {
        for (String visitor : visitors) {
            friendPoints.put(visitor, friendPoints.getOrDefault(visitor, 1) + 1);
        }
    }

    private static List<String> getRecommendation(Map<String, Integer> friendPoints, List<String> userFriends, String user) {
        return friendPoints.entrySet().stream()
                .filter(friend -> friend.getKey() != user && !userFriends.contains(friend.getKey()) && friendPoints.get(friend.getKey()) > 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toUnmodifiableList());
    }
}
