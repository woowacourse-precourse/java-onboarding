package onboarding;

import net.bytebuddy.description.annotation.AnnotationList;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Set<String>> friendsGraph = createGraph(friends);
        Map<String, Integer> scoreList = createScoreMap(user, friends, visitors);

        Set<String> myFriends = friendsGraph.get(user);
        for (String myFriend : myFriends) {
            for (String friendOfFriend : friendsGraph.get(myFriend)) {
                if(scoreList.containsKey(friendOfFriend)){
                    scoreList.put(friendOfFriend, scoreList.get(friendOfFriend) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if(!myFriends.contains(visitor)){
                scoreList.put(visitor, scoreList.get(visitor) + 1);
            }
        }

        return new ArrayList<>(recommendFriends(scoreList).keySet());
    }

    private static Map<String, Set<String>> createGraph(List<List<String>> friends) {
        Map<String, Set<String>> friendsGraph = initNode(friends); // 그래프 노드 정의
        linkingNode(friends, friendsGraph); // 각 노드간 연결 정의
        return friendsGraph;
    }

    private static Map<String, Set<String>> initNode(List<List<String>> nameList) {
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

    private static Map<String, Integer> createScoreMap(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            for (String name : friend) {
                if(!name.equals(user)){
                    scoreMap.put(name,0);
                }
            }
        }

        for (String visitor : visitors) {
            scoreMap.put(visitor,0);
        }

        return sortByKey(scoreMap);
    }

    private static LinkedHashMap<String, Integer> sortByKey(Map<String, Integer> scoreMap) {
        return scoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    private static HashMap<String, Integer> recommendFriends(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .filter(key -> key.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}