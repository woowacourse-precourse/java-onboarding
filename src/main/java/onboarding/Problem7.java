package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem7 {
    static Map<String, List<String>> friendsListMap = new HashMap<>();
    static Map<String, Integer> recommendScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        connectFriends(friends);

        findFriendsScore(user);

        visitScore(user, visitors);

        return recommendScore.entrySet().stream().
                filter(f -> !friendsListMap.get(user).contains(f.getKey())).
                sorted(Map.Entry.comparingByKey()).
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                map(f -> f.getKey()).
                limit(5).
                collect(Collectors.toList());
    }


    public static void connectFriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friendsListMap.containsKey(friend.get(0))) {
                friendsListMap.get(friend.get(0)).add(friend.get(1));

            } else {
                friendsListMap.put(friend.get(0), new ArrayList<>(Collections.singleton(friend.get(1))));
            }

            if (friendsListMap.containsKey(friend.get(1))) {
                friendsListMap.get(friend.get(1)).add(friend.get(0));
            } else {
                friendsListMap.put(friend.get(1), new ArrayList<>(Collections.singleton(friend.get(0))));
            }
        }
    }

    public static void findFriendsScore(String user) {
        for (String userFriend : friendsListMap.get(user)) {
            for (String friendName : friendsListMap.get(userFriend)) {
                if (user.equals(friendName)){   //자기 자신 제외
                    continue;
                }else if (recommendScore.containsKey(friendName)) {
                    recommendScore.put(friendName, recommendScore.get(friendName) + 10);
                } else {
                    recommendScore.put(friendName, 10);
                }
            }
        }
    }

    public static void visitScore(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (!friendsListMap.get(user).contains(visitor)) {
                if (user.equals(visitor)) {   //자기 자신 제외
                    continue;
                }else if (recommendScore.containsKey(visitor)) {
                    recommendScore.put(visitor, recommendScore.get(visitor) + 1);
                } else {
                    recommendScore.put(visitor, 1);
                }
            }
        }
    }
}