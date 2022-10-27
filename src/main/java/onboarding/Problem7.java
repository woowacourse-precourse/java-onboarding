package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, HashSet<String>> graph = new HashMap<>();
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
        return answer;
    }
}