package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class Problem7 {
    private static Map<String, HashSet<String>> graph = new HashMap<>();
    private static Map<String, Integer> scores = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        graph.put(user, new HashSet<>());

        for (List<String> idList: friends){
            String idA = idList.get(0), idB = idList.get(1);
            if (!graph.containsKey(idA))
                graph.put(idA, new HashSet<>());
            if (!graph.containsKey(idB))
                graph.put(idB, new HashSet<>());

            graph.get(idA).add(idB);
            graph.get(idB).add(idA);
        }

        addScoreByMutualFriend(user);
        addScoreByVisits(visitors, user);

        return answer;
    }

    private static void addScoreByMutualFriend(String user){
        for (String friend: graph.get(user)){
            for (String name: graph.get(friend)){
                if (name.equals(user)) continue;
                if (graph.get(user).contains(name)) continue;

                scores.put(name, scores.getOrDefault(name, 0) + 10);
            }
        }
    }

    private static void addScoreByVisits(List<String> visitors, String user){
        for (String visitor: visitors){
            if (graph.get(user).contains(visitor)) continue;

            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }
}