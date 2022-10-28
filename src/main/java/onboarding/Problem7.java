package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendsRelationMap = createFriendRelations(friends);
        Set<String> userFriendsSet = createUserFriends(user, friendsRelationMap);
        List<String> notUserFriendList = createNotUserFriendRelations(friendsRelationMap, userFriendsSet);
        List<String> notUserFriendVisitorList = createNotUserFriendsVisitors(visitors, userFriendsSet);
        notUserFriendList.addAll(notUserFriendVisitorList);
        Map<String, Integer> scoreMap = createScoreInList(notUserFriendList);
        increaseVisitorsOnScoreMap(notUserFriendVisitorList, scoreMap);
        increaseUserFriendsOnScoreMap(user, friendsRelationMap, scoreMap);
        List<String> answer = scoreMap.keySet().stream()
                .sorted((o1, o2) -> {
                    if (scoreMap.get(o2).equals(scoreMap.get(o1)))
                        return o1.compareTo(o2);
                    return scoreMap.get(o2).compareTo(scoreMap.get(o1));
                })
                .collect(Collectors.toList());
        return answer;
    }

    private static List<String> createNotUserFriendsVisitors(List<String> visitors, Set<String> userFriendsSet) {
        return visitors.stream()
                .filter(visitor -> !userFriendsSet.contains(visitor))
                .collect(Collectors.toList());
    }

    private static List<String> createNotUserFriendRelations(Map<String, Set<String>> friendsRelationMap, Set<String> userFriendsSet) {
        return friendsRelationMap.keySet().stream()
                .filter(userId -> !userFriendsSet.contains(userId))
                .collect(Collectors.toList());
    }

    private static Set<String> createUserFriends(String user, Map<String, Set<String>> friendsRelationMap) {
        return friendsRelationMap.keySet().stream()
                .filter(userId -> userId.equals(user) || friendsRelationMap.get(user).contains(userId))
                .collect(Collectors.toSet());
    }

    private static void increaseUserFriendsOnScoreMap(String user, Map<String, Set<String>> friendsRelationMap, Map<String, Integer> scoreMap) {
        friendsRelationMap.get(user).forEach(userFriend -> {
            friendsRelationMap.get(userFriend).forEach(friend -> increaseFriend10(scoreMap, friend));
        });
    }

    private static void increaseFriend10(Map<String, Integer> scoreMap, String friend) {
        if (scoreMap.containsKey(friend))
            scoreMap.put(friend, scoreMap.get(friend) + 10);
    }

    private static void increaseVisitorsOnScoreMap(List<String> visitors, Map<String, Integer> scoreMap) {
        visitors.forEach(userId -> {
            if (scoreMap.containsKey(userId))
                scoreMap.merge(userId, scoreMap.get(userId), Integer::sum);
        });
    }

    private static Map<String, Integer> createScoreInList(List<String> list) {
        Map<String, Integer> scoreMap = new HashMap<>();
        list.forEach(userId -> scoreMap.put(userId, 0));
        return scoreMap;
    }

    private static Map<String, Set<String>> createFriendRelations(List<List<String>> friends) {
        Map<String, Set<String>> friendRelationMap = new HashMap<>();
        friends.forEach(list -> {
            addAtoBInMap(list.get(0), list.get(1), friendRelationMap);
            addAtoBInMap(list.get(1), list.get(0), friendRelationMap);
        });
        return friendRelationMap;
    }

    private static void addAtoBInMap(String a, String b, Map<String, Set<String>> map) {
        if (map.containsKey(b))
            map.get(b).add(a);
        else
            map.put(b, new HashSet<>(Collections.singletonList(a)));
    }
}