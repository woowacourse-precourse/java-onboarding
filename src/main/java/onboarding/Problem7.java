package onboarding;

import java.util.*;
import java.util.stream.*;


public class Problem7 {
    private static Map<String, Set<String>> friendsMap;
    private static Set<String> userFriendSet;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeFriendsMap(friends);
        Map<String, Integer> userPointMap = scorePointByVisitor(visitors, scorePointByAcquaintance(user));
        return sortUserByPointAndName(userPointMap);
    }

    private static List<String> sortUserByPointAndName(Map<String, Integer> pointMap) {
        Stream<Map.Entry<String, Integer>> stream = pointMap.entrySet().stream();
        return stream.sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> scorePointByVisitor(List<String> visitors, Map<String, Integer> pointMap) {
        if (visitors.size() == 0) return pointMap;

        for (String visitor : visitors) {
            if(userFriendSet != null && userFriendSet.contains(visitor)) continue;

            if (pointMap.containsKey(visitor)) {
                pointMap.put(visitor, pointMap.get(visitor) + 1);
                continue;
            }
            pointMap.put(visitor, 1);
        }
        return pointMap;
    }

    private static Map<String, Integer> scorePointByAcquaintance(String user) {
        Map<String, Integer> pointMap = new HashMap<>();
        userFriendSet = friendsMap.get(user);

        if (userFriendSet == null) return pointMap;

        for (String friend : friendsMap.keySet()) {
            if (friend.equals(user) || userFriendSet.contains(friend)) continue;
            int point = verifyAcquaintance(friendsMap.get(friend));
            pointMap.put(friend, point * 10);
        }
        return pointMap;
    }
    private static int verifyAcquaintance(Set<String> setA) {
        Set<String> setB = new HashSet<>(setA);
        setB.retainAll(userFriendSet);

        return setB.size();
    }

    private static void makeFriendsMap(List<List<String>> friends) {
        friendsMap = new HashMap<>();
        String userA, userB;

        for (List<String> friend : friends) {
            userA = friend.get(0);
            userB = friend.get(1);

            addUserToFriendsMap(userA, userB);
            addUserToFriendsMap(userB, userA);
        }
    }

    private static void addUserToFriendsMap(String user, String newFriend) {
        if (!friendsMap.containsKey(user)) {
            friendsMap.put(user, new HashSet<>());
        }
        friendsMap.get(user).add(newFriend);
    }
}
