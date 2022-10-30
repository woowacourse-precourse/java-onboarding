package onboarding;

import net.bytebuddy.description.annotation.AnnotationList;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Map<String, Set<String>> createGraph(List<List<String>> friends) {
        Map<String, Set<String>> friendsGraph = initGraph(friends); // 그래프 노드 정의
        linkingNode(friends, friendsGraph); // 각 노드간 연결 정의
        return friendsGraph;
    }

    private static Map<String, Set<String>> initGraph(List<List<String>> nameList) {
        Map<String, Set<String>> graph = new HashMap<>();
        // name 그래프 초기화
        for (List<String> names : nameList) {
            for (String name : names) { // friends 안의 모든 데이터를 조회
                graph.put(name, new HashSet<>()); // 그래프의 node 값 지정
            }
        }
        return graph;
    }

    private static void linkingNode(List<List<String>> friends, Map<String, Set<String>> friendsGraph) {
        for (List<String> friend : friends) { // line 연결
            String friendName1 = friend.get(0);
            String friendName2 = friend.get(1);

            if(friendsGraph.containsKey(friendName1)){
                friendsGraph.get(friendName1).add(friendName2);
            }

            if(friendsGraph.containsKey(friendName2)){
                friendsGraph.get(friendName2).add(friendName1);
            }
        }
    }

}