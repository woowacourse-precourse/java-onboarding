package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {

    private static Map<String, List<String>> friendToFriendsMap;
    private static Map<String, Integer> friendToScoreMap;
    private static Boolean isExistUserFriend;

    private static final Integer friendScore = 10;
    private static final Integer visitScore = 1;

    private static final Comparator<Map.Entry<String, Integer>> valueComparator =
            Map.Entry.comparingByValue(Comparator.reverseOrder());
    private static final Comparator<Map.Entry<String, Integer>> keyComparator =
            Map.Entry.comparingByKey();

    public static List<String> solution(String user, List<List<String>> friends,
            List<String> visitors) {

        friendToFriendsMap = new HashMap<>();
        friendToScoreMap = new HashMap<>();

        makeUserToFriendsMap(friends);
        isExistUserFriend = friendToFriendsMap.containsKey(user) ? Boolean.TRUE : Boolean.FALSE;

        if (isExistUserFriend)
            calculateFriendScore(user);

        calculateVisitScore(user, visitors);

        return friendToScoreMap.entrySet().stream()
                .sorted(valueComparator.thenComparing(keyComparator))
                .filter(s -> s.getValue() > 0)
                .limit(5)
                .map(Entry::getKey).collect(Collectors.toList());
    }

    public static void makeUserToFriendsMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            putFriend(friendA, friendB);
            putFriend(friendB, friendA);
        }
    }

    public static void putFriend(String friendA, String friendB) {
        if (friendToFriendsMap.containsKey(friendA)) {
            friendToFriendsMap.get(friendA).add(friendB);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(friendB);
            friendToFriendsMap.put(friendA, newList);
        }
    }

    public static void calculateFriendScore(String user) {
        friendToFriendsMap.forEach((otherUser, friends) -> {
            if (otherUser.equals(user))
                return;
            if (friendToFriendsMap.get(user).contains(otherUser))
                return;

            int friendCount = 0;
            for (String friend : friends) {
                if (friendToFriendsMap.get(user).contains(friend))
                    friendCount++;
            }
            friendToScoreMap.put(otherUser, friendCount * friendScore);
        });
    }

    public static void calculateVisitScore(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (isExistUserFriend)
                if (friendToFriendsMap.get(user).contains(visitor))
                    continue;

            if (friendToScoreMap.containsKey(visitor)) {
                friendToScoreMap.put(visitor, friendToScoreMap.get(visitor) + visitScore);
            } else {
                friendToScoreMap.put(visitor, visitScore);
            }
        }
    }
}
