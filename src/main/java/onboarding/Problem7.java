package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, LinkedList<String>> initGraph(List<List<String>> friends){
        Map<String, LinkedList<String>> graph=new HashMap<>();
        friends.forEach(o->{
            String person1 = o.get(0);
            String person2 = o.get(1);

            LinkedList<String> graph1 = graph.getOrDefault(person1, new LinkedList<>());
            LinkedList<String> graph2 = graph.getOrDefault(person2, new LinkedList<>());

            graph1.add(person2);
            graph2.add(person1);

            graph.put(person1, graph1);
            graph.put(person2, graph2);
        });

        return graph;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
