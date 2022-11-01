package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String, Set<String>> friendsMap;
    private static Map<String, Integer> scoreMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        friendsMap = new HashMap<>();
        scoreMap = new HashMap<>();

        friendsMap.put(user, new HashSet<>());
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriendsToMap(friend1, friend2);
            addFriendsToMap(friend2, friend1);
        }
        addVisitorScore(visitors);
        calculateFriendsScore(user);

        return getSortedResult(user);
    }

    private static void addFriendsToMap(String keyFriend, String valueFriend) {
        if (!friendsMap.containsKey(keyFriend)) {
            friendsMap.put(keyFriend, new HashSet<>());
        }
        friendsMap.get(keyFriend).add(valueFriend);
    }

    private static void addVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 0);
            }
            scoreMap.put(visitor, scoreMap.get(visitor) + 1);
        }
    }

    private static void calculateFriendsScore(String user) {
        Set<String> friends = friendsMap.get(user);
        for (String friend : friends) {
            Set<String> friendsOfFriends = friendsMap.get(friend);
            calculateFriendsOfFriends(user, friendsOfFriends);
        }
    }

    private static void calculateFriendsOfFriends(String user, Set<String> friendsOfFriends) {
        for (String person : friendsOfFriends) {
            if (!person.equals(user) && !friendsMap.get(person).contains(user)) {
                scoreMap.put(person, friendsMap.get(person).size() * 10 + scoreMap.getOrDefault(person, 0));
            }
        }
    }

    private static List<String> getSortedResult(String user) {
        List<String> result = new ArrayList<>(scoreMap.keySet());;
        result = result.stream().filter(o -> !friendsMap.get(user).contains(o)).collect(Collectors.toList());
        result.sort(((o1, o2) -> (scoreMap.get(o2).compareTo(scoreMap.get(o1)))));
        return result;
    }
}