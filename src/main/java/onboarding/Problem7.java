package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    Map<String, Integer> user_score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    void setVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (user_score.containsKey(visitor)) {
                user_score.put(visitor, user_score.get(visitor) + 1);
            } else {user_score.put(visitor, 1);}
        }
    }
}
