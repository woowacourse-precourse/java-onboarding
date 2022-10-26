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

        Set<String> friends= new HashSet<>(graph.get(user));

        graph.keySet().stream()
                .filter(o->!o.equals(user))
                .filter(o->!friends.contains(o))
                .forEach(o->scoreBoard.put(o, 0));

        return scoreBoard;
    }

    public static void scoreFriendToFriend(Map<String, LinkedList<String>> graph,
                                           Map<String, Integer> scoreBoard,
                                           String user){
        Set<String> friends=new HashSet<>(graph.get(user));
        friends.stream()
                .flatMap(o->graph.get(o).stream())
                .filter(o->!o.equals(user))
                .filter(o->!friends.contains(o))
                .forEach(o-> scoreBoard.put(o, scoreBoard.get(o)+10));
    }

    public static void scoreVisitors(LinkedList<String> friends,
                                     List<String> visitors,
                                     Map<String, Integer> scoreBoard){
        Set<String> friendSet=new HashSet<>(friends);

        visitors.stream()
                .filter(o->!friendSet.contains(o))
                .forEach(o-> scoreBoard.put(o, scoreBoard.getOrDefault(o, 0)+1));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, LinkedList<String>> friendsGraph = initGraph(friends);
        Map<String, Integer> scoreBoard = initScoreBoard(friendsGraph, user);

        scoreFriendToFriend(friendsGraph, scoreBoard, user);
        scoreVisitors(friendsGraph.get(user), visitors, scoreBoard);

        return scoreBoard.entrySet().stream()
                .filter(o->o.getValue()!=0)
                .sorted((o1, o2)->{
                    if(o1.getValue()!=o2.getValue())
                        return o2.getValue()-o1.getValue();

                    return o1.getKey().compareTo(o2.getKey());
                })
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
