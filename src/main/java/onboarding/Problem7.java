package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    private static HashMap<String, HashSet<String>> getGraphOf(List<List<String>> friends){
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        for(List<String> friend:friends){
            String v1 = friend.get(0);
            String v2 = friend.get(1);

            if(graph.containsKey(v1))
                graph.get(v1).add(v2);
            else
                graph.put(v1, new HashSet<>(Collections.singletonList(v2)));

            if(graph.containsKey(v2))
                graph.get(v2).add(v1);
            else
                graph.put(v2, new HashSet<>(Collections.singletonList(v1)));
        }
        return graph;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> graph = getGraphOf(friends);


        return null;
    }
}
