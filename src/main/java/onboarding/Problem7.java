package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = new HashSet<>();
        friends.forEach(elem -> constructFriendsSet(userFriends, user, elem.get(0), elem.get(1)));

        List<String> friendsOfUserFriends = new ArrayList<>();
        userFriends.forEach(elem -> constructFriendsList(elem, friendsOfUserFriends, friends));

        Map<String, Integer> scoreOfFriends = new HashMap<>();
        addScores(scoreOfFriends, userFriends, user, friendsOfUserFriends, visitors);
        return getAnswer(scoreOfFriends, userFriends, user);

    }

    private static void constructFriendsSet(Set<String> setFriends,
                                            String target,
                                            String friendA,
                                            String friendB) {
        if (friendA.equals(target)) {
            setFriends.add(friendB);
        }
        if (friendB.equals(target)) {
            setFriends.add(friendA);
        }
    }

    private static void constructFriendsList(String target,
                                             List<String> listFriends,
                                             List<List<String>> friends) {
        Set<String> targetFriends = new HashSet<>();
        friends.forEach(elem -> constructFriendsSet(targetFriends, target, elem.get(0), elem.get(1)));
        targetFriends.forEach(elem -> listFriends.add(elem));
    }

    private static Map<String, Integer> addScores(Map<String, Integer> scores,
                                                  Set<String> userFriends,
                                                  String user,
                                                  List<String> commonFriends,
                                                  List<String> visitors) {
        commonFriends.forEach(item -> addCommonFriendsScores(scores, userFriends, item, user));
        visitors.forEach(item -> scores.put(item, scores.containsKey(item) ? scores.get(item) + 1 : 1));
        return scores;
    }

    private static void addCommonFriendsScores(Map<String, Integer> scores,
                                               Set<String> userFriends,
                                               String target,
                                               String user) {
        if (!userFriends.contains(target) && !target.equals(user)) {
            scores.put(target, scores.containsKey(target) ? scores.get(target) + 10 : 0);
        }
    }

    private static List<String> getAnswer(Map<String, Integer> scores,
                                          Set<String> userFriends,
                                          String user) {
        return scores.entrySet().stream()
                .filter(item -> !item.getKey().equals(user) && !userFriends.contains(item.getKey()))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }
}
