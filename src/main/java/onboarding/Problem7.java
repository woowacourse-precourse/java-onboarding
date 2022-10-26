package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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

    public static Map<String, Integer> initScoreBoard(Map<String, LinkedList<String>> graph, String user){
        Map<String, Integer> scoreBoard=new HashMap<>();

        Set<String> userFriends= new HashSet<>(graph.get(user));

        graph.keySet().stream()
                .filter(o->!o.equals(user))
                .filter(o->!userFriends.contains(o))
                .forEach(o->scoreBoard.put(o, 0));

        return scoreBoard;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
