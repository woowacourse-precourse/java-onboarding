package onboarding;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userInfo = new HashMap<>();
        Set<String> myFriends = new HashSet<>();

        friends.stream()
                .filter(friend -> friend.contains(user))
                .forEach(myFriends::addAll);

        for (String visitor : visitors) {
            userInfo.put(visitor, userInfo.getOrDefault(visitor, 0) + 1);
        }

        friends.stream()
                .flatMap(Collection::stream)
                .filter(username -> !myFriends.contains(username))
                .forEach(username -> userInfo.put(username, userInfo.getOrDefault(username, 0) + 10));

        for (String friend : myFriends) {
            userInfo.remove(friend);
        }
        userInfo.remove(user);

        List<String> answer = new ArrayList<>(userInfo.keySet());
        answer.sort(((o1, o2) -> userInfo.get(o2).compareTo(userInfo.get(o1))));
        return answer;
    }
}

