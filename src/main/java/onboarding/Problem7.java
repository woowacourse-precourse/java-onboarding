package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> nearFriend = new HashMap<>();
        List<String> realFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                realFriends.add(friend.get(1));
                continue;
            }
            if (friend.get(1).equals(user)) {
                realFriends.add(friend.get(0));
                continue;
            }
            nearFriend.compute(friend.get(0), (key, value) -> value == null ? new ArrayList<>() : value)
                .add(friend.get(1));
        }
        Map<String, Integer> scores = new HashMap<>();
        for (String visitor : visitors) {
            if (!nearFriend.containsKey(visitor)) {
                scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
            }
        }
        for (List<String> nearFriends : nearFriend.values()) {
            for (String friend : nearFriends) {
                scores.put(friend, scores.getOrDefault(friend, 0) + 10);
            }
        }
        return answer;
    }
}
