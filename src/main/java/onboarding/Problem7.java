package onboarding;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int FIRST_FRIEND = 0;
    private static final int SECOND_FRIEND = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userInfo = new HashMap<>();
        Set<String> myFriends = new HashSet<>();

        for (List<String> friend : friends) {
            userInfo.put(friend.get(0), FIRST_FRIEND);
            userInfo.put(friend.get(1), SECOND_FRIEND);
        }
        friends.stream()
                .filter(friend -> friend.contains(user))
                .forEach(myFriends::addAll);
        List<String> myFriend = new ArrayList<>(myFriends);

        for (String visitor : visitors) {
            userInfo.put(visitor, userInfo.getOrDefault(visitor, 0) + 1);
        }

        for (List<String> strings : friends) {
            for (int j = 0; j < 2; j++) {
                if (strings.contains(myFriend.get(0))) {
                    userInfo.put(strings.get(1), userInfo.get(strings.get(1)) + 10);
                }
                if (strings.contains(myFriend.get(1))) {
                    userInfo.put(strings.get(0), userInfo.get(strings.get(0)) + 10);
                }
            }
        }
        userInfo.remove(user);
        for (String friend : myFriend) {
            userInfo.remove(friend);
        }
        List<String> answer = new ArrayList<>(userInfo.keySet());
        answer.sort(((o1, o2) -> userInfo.get(o2).compareTo(userInfo.get(o1))));
        return answer;
    }
}

