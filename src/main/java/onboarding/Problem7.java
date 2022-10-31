package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    private static final Set<String> userFriends = new HashSet<>();
    private static final Map<String, Integer> recommendScoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        setFriendsOfUser(user, friends);
        return answer;
    }

    private static void setFriendsOfUser(String user, List<List<String>> friends) {
        friends.stream()
                .filter(friend -> friend.contains(user))
                .forEach(userFriends::addAll);

        userFriends.remove(user);
    }
}
