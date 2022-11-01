package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int POINT_OF_FRIEND_TOGETHER = 10;
    private static final int POINT_OF_VISIT_COUNT_PER_TIMELINE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, ArrayList<String>> graph = makeFriendGraph(friends);

        return answer;
    }

    private static Map<String, ArrayList<String>> makeFriendGraph(List<List<String>> friends) {
        Map<String, ArrayList<String>> graph = new HashMap();

        for(List<String> current:friends){
            String person1 = current.get(0);
            String person2 = current.get(1);


            if(graph.containsKey(person1)){
                graph.get(person1).add(person2);
            } else{
                ArrayList<String> newArrayList = new ArrayList();
                newArrayList.add(person2);
                graph.put(person1, newArrayList);

            }

            if(graph.containsKey(person2)){
                graph.get(person2).add(person1);
            } else{
                ArrayList<String> newArrayList = new ArrayList();
                newArrayList.add(person1);
                graph.put(person2, newArrayList);

            }
        }
//        for(String key : graph.keySet()) {
//            ArrayList<String> value = graph.get(key);
//            System.out.println(key);
//            System.out.println(value);
//        }
        return graph;
    }
}
