package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void addFriend(Map<String, List<String>> friendMap, Map<String, Integer> friendScoreMap, String friendA, String friendB) {
        if (!friendMap.containsKey(friendA)) {
            List<String> friends = new LinkedList<>();
            friends.add(friendB);

            friendMap.put(friendA, friends);
            friendScoreMap.put(friendA, 0);
        }
        else {
            List<String> friends = friendMap.get(friendA);
            friends.add(friendB);
        }
    }
}
