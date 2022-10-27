package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static Map<String, Integer> excludedUserMap;
    static Map<String, List<String>> friendMap;
    static Map<String, Integer> acquaintanceScoreMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        excludedUserMap = new HashMap<>();
        friendMap = new HashMap<>();
        acquaintanceScoreMap = new HashMap<>();
        initFriendMap(friends);
        initExcludeUserMap(user);
        return null;
    }

    private static void initExcludeUserMap(String user) {
        excludedUserMap.put(user, 1);
        for (String friend : friendMap.get(user)) {
            excludedUserMap.put(friend, 1);
        }
    }

    private static void initFriendMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            friendMap.computeIfAbsent(user1, k -> new ArrayList<>());
            friendMap.computeIfAbsent(user2, k -> new ArrayList<>());
            friendMap.get(user1).add(user2);
            friendMap.get(user2).add(user1);

        }
    }

}
