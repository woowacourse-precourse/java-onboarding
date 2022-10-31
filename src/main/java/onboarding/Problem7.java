package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsInfoMap = new HashMap<>();
        List<String> userFriends = new ArrayList<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        for (List<String> friendInfo : friends) {
            String userA = friendInfo.get(0);
            String userB = friendInfo.get(1);
            createFriendMap(friendsInfoMap, user, userA, userB, userFriends);
        }

        for (String userFriend : userFriends) {
            List<String> crossFriends = friendsInfoMap.get(userFriend);
            addScoreToMap(FRIEND_SCORE, crossFriends, userFriends, scoreMap);
        }

        addScoreToMap(VISITOR_SCORE, visitors, userFriends, scoreMap);

        return getSortedList(scoreMap);
    }

    private static void createFriendMap(Map<String, List<String>> friendsMap, String user, String userA, String userB, List<String> userFriends) {
        if (isSameName(userA, user) || isSameName(userB, user)) {
            String friendName = (user.equals(userA)) ? userB : userA;
            addFriendToList(userFriends, friendName);
            return;
        }
        addFriendToMap(friendsMap, userA, userB);
        addFriendToMap(friendsMap, userB, userA);
    }

    private static void addScoreToMap(int plusScore, List<String> friendOrVisitor, List<String> userFriends, Map<String, Integer> scoreMap) {
        friendOrVisitor.stream()
                .filter(key -> !isAlreadyFriend(userFriends, key))
                .forEach(key -> scoreMap.put(key, scoreMap.getOrDefault(key, 0) + plusScore));
    }

    private static List<String> getSortedList(Map<String, Integer> scoreMap) {
        return scoreMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue)
                        .reversed().thenComparing(Map.Entry::getKey))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void addFriendToMap(Map<String, List<String>> friendsMap, String userA, String userB) {
        friendsMap.compute(userB, (k, v) -> v == null ? new ArrayList<>() : v).add(userA);
    }

    private static boolean isSameName(String friendName, String userName) {
        return friendName.equals(userName);
    }

    private static boolean isAlreadyFriend(List<String> userFriends, String friendName) {
        return userFriends.contains(friendName);
    }

    private static void addFriendToList(List<String> userFriends, String friendName) {
        userFriends.add(friendName);
    }
}
