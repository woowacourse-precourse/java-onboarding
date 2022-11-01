package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    private List<String> getScore(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);
            if(friends.contains(user)){  // 사용자를 포함하고 있다면 친구 관계
                plusMoreScore(scoreMap, friend1, friend2, user);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if(!scoreMap.containsKey(visitor)){  // 친구가 아닐때만 방문 시 +1
                scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0)+1);
            }
        }
        return new ArrayList<>();
    }

    private void plusMoreScore(HashMap<String, Integer> scoreMap, String friend1, String friend2, String user) {
        if(friend1.equals(user)) {
            scoreMap.put(friend1, scoreMap.getOrDefault(friend1, 0) + 10);
        } else {
            scoreMap.put(friend2, scoreMap.getOrDefault(friend2, 0) + 10);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Problem7 problem7 = new Problem7();
        answer = problem7.getScore(user, friends, visitors);


        return answer;
    }
}
