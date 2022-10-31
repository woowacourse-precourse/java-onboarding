package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Friends> userFriends = new HashMap<>();

        registerFriends(friends, userFriends);
        return Collections.emptyList();
    }

    private static void registerFriends(List<List<String>> friends, Map<String, Friends> userFriends) {
        friends.forEach(friend -> register(friend, userFriends));
    }

    private static void register(List<String> friend, Map<String, Friends> userFriends) {
        String first = friend.get(0);
        String second = friend.get(1);

        userFriends.computeIfAbsent(first, user -> new Friends());
        userFriends.computeIfAbsent(second, user -> new Friends());
        userFriends.get(first).add(second);
        userFriends.get(second).add(first);
    }
}
