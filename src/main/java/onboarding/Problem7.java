package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> userToScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> myFriends = new HashSet<>();

        friends.stream()
                .filter(friend -> isFriendsContainsUser(friend, user))
                .forEach(myFriends::addAll);

        friends.stream()
                .filter(friend -> myFriends.contains(friend.get(0)) || myFriends.contains(friend.get(1)))
                .forEach(friend -> {
                    increaseUserScore(friend.get(0), 10);
                    increaseUserScore(friend.get(1), 10);
                });

        visitors.forEach(visitor -> increaseUserScore(visitor, 1));

        return userToScore.entrySet().stream().filter(e -> !myFriends.contains(e.getKey()) && e.getValue() > 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void increaseUserScore(String user, int score) {
        userToScore.put(user, userToScore.getOrDefault(user, 0) + score);
    }

    private static boolean isFriendsContainsUser(List<String> friend, String user) {
        return friend.contains(user);
    }
}
