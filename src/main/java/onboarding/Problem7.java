package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int A = 0;
    private static final int B = 1;
    private static final int MAX_NUMBER_FRIENDS = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = new HashSet<>();
        friends.forEach(friend -> constructFriendsSet(userFriends, user, friend.get(A), friend.get(B)));

        List<String> friendsOfUserFriends = new ArrayList<>();
        userFriends.forEach(friend -> constructFriendsList(friend, friendsOfUserFriends, friends));

        Map<String, Integer> scoreOfFriends = new HashMap<>();
        addScores(scoreOfFriends, userFriends, user, friendsOfUserFriends, visitors);
        return findFiveHighest(scoreOfFriends, userFriends, user);
    }

    private static void constructFriendsSet(Set<String> friends, String target, String friendA, String friendB) {
        if (friendA.equals(target)) {
            friends.add(friendB);
        }
        if (friendB.equals(target)) {
            friends.add(friendA);
        }
    }

    private static void constructFriendsList(String target, List<String> listFriends, List<List<String>> friends) {
        Set<String> targetFriends = new HashSet<>();
        friends.forEach(friend -> constructFriendsSet(targetFriends, target, friend.get(A), friend.get(B)));
        listFriends.addAll(targetFriends);
    }

    private static void addScores(Map<String, Integer> scores,
                                  Set<String> userFriends,
                                  String user,
                                  List<String> commonFriends,
                                  List<String> visitors) {
        commonFriends.forEach(item -> addCommonFriendsScores(scores, userFriends, item, user));
        visitors.forEach(item -> scores.put(item, scores.containsKey(item) ? scores.get(item) + 1 : 1));
    }

    private static void addCommonFriendsScores(Map<String, Integer> scores,
                                               Set<String> userFriends,
                                               String target,
                                               String user) {
        if (!userFriends.contains(target) && !target.equals(user)) {
            scores.put(target, scores.containsKey(target) ? scores.get(target) + 10 : 0);
        }
    }

    private static List<String> findFiveHighest(Map<String, Integer> scores, Set<String> userFriends, String user) {
        return scores.entrySet().stream()
                .filter(item -> !item.getKey().equals(user) && !userFriends.contains(item.getKey()))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(MAX_NUMBER_FRIENDS)
                .collect(Collectors.toList());
    }
}
