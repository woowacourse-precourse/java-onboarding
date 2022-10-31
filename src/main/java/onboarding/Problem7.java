package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static Map<String, Integer> score = new HashMap<>();
    static List<String> friendsList = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void setFriendScore(List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            List<String> s = friends.get(i);
            if (!score.containsKey(s.get(0))) {
                score.put(s.get(0), 0);
            }
            if (!score.containsKey(score.get(1))) {
                score.put(s.get(1), 0);
            }
        }
    }
}
