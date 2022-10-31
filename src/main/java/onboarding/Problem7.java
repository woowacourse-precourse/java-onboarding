package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendGraph = createFrinedGraph(friends);
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, List<String>> createFrinedGraph(List<List<String>> friends){
        Map<String, List<String>> friendGraph = new HashMap<>();
        for (List<String> friendRelation : friends){
            String userA = friendRelation.get(0), userB = friendRelation.get(1);
            addToGraph(friendGraph, userA, userB);
        }
        return friendGraph;
    }

    public static void addToGraph(Map<String, List<String>> friendGraph ,String userA, String userB){
        // userA가 friendGraph의 key값으로 이미 있을 경우 -> userB를 List에 추가한다.
        // 없다면 userA를 key값에 추가하고 리스트를 새로 생성 후 userB를 추가한다.
        if(friendGraph.containsKey(userA)){
            friendGraph.get(userA).add(userB);
        }
        if(!friendGraph.containsKey(userA)){
            friendGraph.put(userA, new ArrayList<>(List.of(userB)));
        }
        // userB에 대해 반복
        if(friendGraph.containsKey(userB)){
            friendGraph.get(userB).add(userA);
        }
        if(!friendGraph.containsKey(userB)){
            friendGraph.put(userB, new ArrayList<>(List.of(userA)));
        }
    }
}
