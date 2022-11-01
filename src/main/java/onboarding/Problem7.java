package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, List<String>> friendMap = new HashMap<>();

        for (List<String> entry : friends) {
            if (!friendMap.containsKey(entry.get(0))) {
                friendMap.put(entry.get(0), new ArrayList<>());
            }
            if (!friendMap.containsKey(entry.get(1))) {
                friendMap.put(entry.get(1), new ArrayList<>());
            }
            friendMap.get(entry.get(0)).add(entry.get(1));
            friendMap.get(entry.get(1)).add(entry.get(0));
        }

        List<String> userFriends = friendMap.get(user);

        for (Map.Entry<String, List<String>> entry : friendMap.entrySet()) {
            String target = entry.getKey();
            if (target.equals(user)) continue;
            List<String> targetFriends = entry.getValue();
            int score = 0;
            for (String userFriend : userFriends) {
                if (targetFriends.contains(userFriend)) {
                    score += 10;
                }
            }
            if (score!=0) scoreMap.put(target, score);
        }

        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.containsKey(visitor) ? scoreMap.get(visitor) + 1 : 1);
        }

        System.out.println(scoreMap);
        scoreMap.remove(user);

        List<String> names = new ArrayList<>(scoreMap.keySet());
        names.sort((s1, s2) -> scoreMap.get(s2).compareTo(scoreMap.get(s1)));
        return names.subList(0, 4);
    }
}
