package onboarding;

import onboarding.problem7.Crew;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendMap = getFriendMap(friends);

        List<String> userFriends = getUserFriends(friendMap, user);
        List<String> userAndUserFriends = getUserAndUserFriends(userFriends, user);
        List<String> acquaintances = getAcquaintances(friendMap, userFriends, user);
        Map<String, Integer> acquaintancesPoint = getAcquaintancesPoint(acquaintances, userAndUserFriends);
        Map<String, Integer> visitorsPoint = getVisitorsPoint(visitors, userAndUserFriends);

        visitorsPoint
                .forEach((key, value) -> acquaintancesPoint.merge(key, value, (value1, value2) -> value1 + value2));

        return acquaintancesPoint.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> new Crew(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(Crew::getPoint).reversed().thenComparing(Crew::getName))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> getFriendMap(List<List<String>> friends) {
        Map<String, List<String>> friendMap = new HashMap<>();
        for (List<String> friendPair : friends) {
            List<String> friend1 = friendMap.getOrDefault(friendPair.get(0), new ArrayList<>());
            List<String> friend2 = friendMap.getOrDefault(friendPair.get(1), new ArrayList<>());
            friend1.add(friendPair.get(1));
            friend2.add(friendPair.get(0));
            friendMap.put(friendPair.get(0), friend1);
            friendMap.put(friendPair.get(1), friend2);
        }
        return friendMap;
    }

    public static Map<String, Integer> getAcquaintancesPoint(List<String> acquaintances, List<String> userAndUserFriends) {
        Map<String, Integer> points = new HashMap<>();
        for (String acquaintance : acquaintances) {
            points.put(acquaintance, points.getOrDefault(acquaintance, 0) + getAcquaintancePoint(acquaintance, userAndUserFriends));
        }
        return points;
    }

    private static int getAcquaintancePoint(String acquaintance, List<String> userAndUserFriends) {
        if (userAndUserFriends.contains(acquaintance)) {
            return 0;
        }
        return 10;
    }

    public static List<String> getUserFriends(Map<String, List<String>> friendMap, String user) {
        return friendMap.get(user);
    }

    public static List<String> getUserAndUserFriends(List<String> userFriends, String user) {
        userFriends.add(user);
        return userFriends;
    }

    public static List<String> getAcquaintances(Map<String, List<String>> friendMap, List<String> userFriends, String user) {
        return userFriends.stream()
                .flatMap(userFriend -> friendMap.get(userFriend).stream())
                .filter(userFriend -> isUserOrUserFriend(userFriends, user, userFriend))
                .collect(Collectors.toList());
    }

    private static boolean isUserOrUserFriend(List<String> userFriends, String user, String userFriend) {
        if (userFriend.equals(user) || userFriends.contains(userFriend)) {
            return false;
        }
        return true;
    }

    public static Map<String, Integer> getVisitorsPoint(List<String> visitors, List<String> userAndUserFriends) {
        Map<String, Integer> points = new HashMap<>();
        for (String visitor : visitors) {
            points.put(visitor, points.getOrDefault(visitor, 0) + getVisitorPoint(visitor, userAndUserFriends));
        }
    }

    private static int getVisitorPoint(String visitor, List<String> userAndUserFriends) {
        if (userAndUserFriends.contains(visitor)) {
            return 0;
        }
        return 1;
    }
}
