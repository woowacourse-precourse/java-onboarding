package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            saveFriend(friendsMap, friend);
        }
        removeUserSelf(user, friendsMap);

        Map<String, Integer> pointMap = new HashMap<>();
        Set<String> userFriends = friendsMap.get(user);

        for (String userFriend : userFriends) {
            Set<String> sharingFriends = friendsMap.get(userFriend);
            giveSharingFriendPoint(pointMap, userFriends, sharingFriends);
        }

        for (String visitor : visitors) {
            if (isFriend(visitor, userFriends)) {
                continue;
            }
            giveVisitPoint(visitor, pointMap);
        }

        return sortByPoint(pointMap);
    }

    private static void saveFriend(Map<String, Set<String>> friendsMap, List<String> friends) {
        String user1 = friends.get(0);
        String user2 = friends.get(1);
        Set<String> user1Friends = getFriends(user1, friendsMap);
        Set<String> user2Friends = getFriends(user2, friendsMap);

        user1Friends.add(user2);
        user2Friends.add(user1);
    }

    private static Set<String> getFriends(String user, Map<String, Set<String>> friendsMap) {
        Set<String> users = friendsMap.keySet();
        if (users.contains(user)) {
            return friendsMap.get(user);
        }
        Set<String> userFriends = new HashSet<>();
        friendsMap.put(user, userFriends);
        return userFriends;
    }

    private static void removeUserSelf(String user, Map<String, Set<String>> friendsMap) {
        friendsMap.values()
                .forEach(friends -> friends.remove(user));
    }

    private static void giveSharingFriendPoint(Map<String, Integer> pointMap,
                                               Set<String> userFriends, Set<String> friendsWithUserFriend) {
        for (String sharingFriend : friendsWithUserFriend) {
            if (isFriend(sharingFriend, userFriends)) {
                continue;
            }
            giveSharingFriendPoint(pointMap, friendsWithUserFriend);
        }
    }

    private static void giveSharingFriendPoint(Map<String, Integer> pointMap, Set<String> friendsWithUserFriend) {
        for (String sharingFriend : friendsWithUserFriend) {
            saveSharingFriendPoint(sharingFriend, pointMap);
        }
    }

    private static void saveSharingFriendPoint(String friend, Map<String, Integer> pointMap) {
        int pointBySharingFriend = 10;
        int pointByUser = getPointByUser(friend, pointMap);

        pointMap.replace(friend, pointByUser + pointBySharingFriend);
    }

    private static int getPointByUser(String friend, Map<String, Integer> pointMap) {
        Set<String> users = pointMap.keySet();
        if (users.contains(friend)) {
            return pointMap.get(friend);
        }
        pointMap.put(friend, 0);
        return 0;
    }

    private static boolean isFriend(String user, Set<String> friends) {
        return friends.stream()
                .anyMatch(friend -> friend.equals(user));
    }

    private static void giveVisitPoint(String visitor, Map<String, Integer> pointMap) {
        int pointByVisitor = 2;
        int pointByUser = getPointByUser(visitor, pointMap);

        pointMap.replace(visitor, pointByUser + pointByVisitor);
    }

    private static List<String> sortByPoint(Map<String, Integer> pointMap) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(pointMap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        return entryList.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}