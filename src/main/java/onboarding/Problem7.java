package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userToScore = new HashMap<>();
        Set<String> myFriends = new HashSet<>();

        for (List<String> friend : friends) {
            if (isFriendsContainsUser(friend, user)){
                myFriends.addAll(friend);
            }
        }

        for (List<String> friend : friends) {
            if (isFriendsContainsUser(friend, user)) {
                continue;
            }
            for (int i = 0; i < 2; i++) {
                if (myFriends.contains(friend.get(i))) {
                    userToScore.put(friend.get(i ^ 1), userToScore.getOrDefault(friend.get(i ^ 1), 0) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (myFriends.contains(visitor)) {
                continue;
            }
            userToScore.put(visitor, userToScore.getOrDefault(visitor, 0) + 1);
        }

        return userToScore.entrySet().stream().filter(e -> e.getValue() > 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static boolean isFriendsContainsUser(List<String> friend, String user) {
        return friend.contains(user);
    }
}
