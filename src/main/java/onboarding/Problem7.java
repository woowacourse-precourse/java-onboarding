package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Problem7 {
    private static Map<String, List<String>> map = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void makeRelationships(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String from = friend.get(0);
            String to = friend.get(1);
            makeFriendBetweenFromAndTo(from, to);
            makeFriendBetweenFromAndTo(to, from);
        }
    }

    private static void makeFriendBetweenFromAndTo(String from, String to) {
        if (!map.containsKey(from)) {
            List<String> friends = new ArrayList<>();
            friends.add(to);
            map.put(from, friends);
        } else {
            map.get(from).add(to);
        }
    }
}
