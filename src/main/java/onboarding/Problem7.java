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

    public static void scoreFriendToFriend(Map<String, LinkedList<String>> graph,
                                           Map<String, Integer> scoreBoard,
                                           String user){
        Set<String> friends=new HashSet<>(graph.get(user));
        friends.stream()
                .flatMap(o->graph.get(o).stream())
                .forEach(o-> scoreBoard.put(o, scoreBoard.getOrDefault(o, 0)+10));
    }

    public static void scoreVisitors(List<String> visitors, Map<String, Integer> scoreBoard){
        visitors.forEach(o-> scoreBoard.put(o, scoreBoard.getOrDefault(o, 0)+1));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, LinkedList<String>> friendsGraph = initGraph(friends);
        Map<String, Integer> scoreBoard = new HashMap<>();

        scoreFriendToFriend(friendsGraph, scoreBoard, user);
        scoreVisitors(visitors, scoreBoard);

        Set<String> userFriends=new HashSet<>(friendsGraph.get(user));
        return scoreBoard.entrySet().stream()
                .filter(o->!o.getKey().equals(user))
                .filter(o->!userFriends.contains(o.getKey()))
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
