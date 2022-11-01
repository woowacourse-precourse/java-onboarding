package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, HashSet<String>> friendMap = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        fillFriendAndScoreMap(friends, friendMap, scoreMap);
        setRecommendScoreByVisit(visitors, scoreMap);

        return answer;
    }

    private static void fillFriendAndScoreMap(List<List<String>> friends, HashMap<String, HashSet<String>> friendMap, HashMap<String, Integer> scoreMap) {
        for (List<String> friend : friends) {
            if (friendMap.containsKey(friend.get(0))) {
                HashSet<String> values = friendMap.get(friend.get(0));
                values.add(friend.get(1));
                friendMap.put(friend.get(0), values);
            } else {
                HashSet<String> values = new HashSet<>();
                values.add(friend.get(1));
                friendMap.put(friend.get(0), values);
                scoreMap.put(friend.get(0), 0);
            }

            if (friendMap.containsKey(friend.get(1))) {
                HashSet<String> values = friendMap.get(friend.get(1));
                values.add(friend.get(0));
                friendMap.put(friend.get(1), values);
            } else {
                HashSet<String> values = new HashSet<>();
                values.add(friend.get(0));
                friendMap.put(friend.get(1), values);
                scoreMap.put(friend.get(1), 0);
            }
        }
    }

        private static void setRecommendScoreByVisit(List<String> visitors, HashMap<String, Integer> scoreMap) {
            for (String friend : visitors) {
                if (scoreMap.containsKey(friend)) {
                    int score = scoreMap.get(friend);
                    scoreMap.put(friend, score + 1);
                } else {
                    scoreMap.put(friend, 0);
                }
            }
        }
    }
}
