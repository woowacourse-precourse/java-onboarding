package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendsList = getFriendsList(user, friends);
        Map<String, Integer> friendPointMap = getFriendPoint(user, friendsList, friends, visitors);
        Map<String, Integer> totalPointMap = plusVisitPoint(friendsList, visitors, friendPointMap);

        return totalPointMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<String> getFriendsList(String user, List<List<String>> friends) {

        List<String> friendsList = new ArrayList<>();

        for (List<String> names : friends) {
            if (user.equals(names.get(0))) {
                friendsList.add(names.get(1));
            }
            if (user.equals(names.get(1))) {
                friendsList.add(names.get(0));
            }
        }
        return friendsList;
    }

    private static Map<String, Integer> getFriendPoint(
            String user, List<String> friendsList, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> pointMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friendName = friend.get(0);
            String friendOfFriend = friend.get(1);
            if (!user.equals(friendOfFriend) && isFriend(friendName, friendsList)) {
                pointMap.put(friendOfFriend, pointMap.getOrDefault(friendOfFriend, 0) + 10);
            }
        }

        return pointMap;
    }

    private static Map<String, Integer> plusVisitPoint(List<String> friendsList, List<String> visitors, Map<String, Integer> friendPointMap) {

        for (String visitor : visitors) {
            if (isFriend(visitor, friendsList)) {
                continue;
            }
            friendPointMap.put(visitor, friendPointMap.getOrDefault(visitor, 0) + 1);
        }
        return friendPointMap;
    }

    private static boolean isFriend(String name, List<String> friendsList) {
        if (friendsList.contains(name)) {
            return true;
        }
        return false;
    }
}