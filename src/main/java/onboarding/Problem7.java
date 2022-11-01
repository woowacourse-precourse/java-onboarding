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
    private static HashMap<String, Integer> addPointByVisitor(HashMap<String, Integer> recommend, List<String> visitors){
        //방문자에 대한 1점 추가
        for(String visitor : visitors){
            if(recommend.containsKey(visitor))
                recommend.put(visitor, recommend.get(visitor)+1);
            else
                recommend.put(visitor, 1);
        }
        return recommend;

    }

    private static HashMap<String, Integer> deleteAlreadyFriend(HashMap<String, Integer> recommend, HashMap<String, HashSet<String>> graph, String user){
        HashSet<String> userFriends = graph.get(user);
        for(String friend:userFriends)
            recommend.remove(friend); //이미 친구이면 기존 추천에서 삭제
        return recommend;
    }



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> graph = getGraphOf(friends);

        //사용자들 추천 점수 0으로 세팅
        HashMap<String, Integer> recommend = new HashMap<>();
        addPointByVisitor(recommend, visitors);
        deleteAlreadyFriend(recommend, graph, user);

        return null;
    }
}
