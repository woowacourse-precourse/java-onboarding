package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static void addEdge(HashMap<String, HashSet<String>> graph, String userFrom, String userTo) {
        if (graph.containsKey(userFrom))
            graph.get(userFrom).add(userTo);
        else
            graph.put(userFrom, new HashSet<>(List.of(userTo)));
    }
}