package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String,Integer> graph =new HashMap<>();



        for (List<String> f: friends){

            graph = makeUserPointList(graph,f, user);
        }

        graph = makeUserPointList(graph,visitors,user);


        Set<String> keySet = graph.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + graph.get(key));
        }


        return answer;
    }



    public static HashMap<String,Integer> makeUserPointList(HashMap<String,Integer> graph,List<String> friend,String user){

        for (int i =0; i < friend.size(); i++){
            if (friend.get(i) != user && graph.get(friend.get(i)) == null) {
                graph.put(friend.get(i),0);
            }
        }


        return graph;
    }


    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(solution(user, friends, visitors));

    }
}
