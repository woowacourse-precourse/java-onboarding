package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;

    private static void appendMapValue(String key, String appendValue,
        HashMap<String, List<String>> map) {
        List<String> values = map.getOrDefault(key, new ArrayList<>());
        values.add(appendValue);
        map.put(key, values);
    }

    private static void updateMapValue(String key, int addScore, HashMap<String, Integer> map) {
        map.put(key, map.getOrDefault(key, 0) + addScore);
    }

    private static void updateMapAll(List<String> keys, int addScore,
        HashMap<String, Integer> map) {
        keys.forEach(key -> updateMapValue(key, addScore, map));
    }

    private static HashMap<String, List<String>> createAdjListGraph(List<List<String>> list) {
        HashMap<String, List<String>> graph = new HashMap<>(); //인접리스트 그래프 생성

        for (List<String> item : list) {
            appendMapValue(item.get(0), item.get(1), graph);
            appendMapValue(item.get(1), item.get(0), graph);
        }
        return graph;
    }

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {

        HashMap<String, List<String>> friendsGraph = createAdjListGraph(friends);

        HashMap<String, Integer> userScore = new HashMap<>(); //user당 점수를 저장하는 해쉬 맵

        //겹치는 친구에 대해서 점수 +10
        friendsGraph.get(user)
            .forEach(friend -> updateMapAll(friendsGraph.get(friend), FRIEND_SCORE, userScore));
        //방문자에 대해서 점수 +1
        updateMapAll(visitors, VISITOR_SCORE, userScore);

        //userScore filtering
        List<Map.Entry<String, Integer>> entries = userScore.entrySet().stream()
            .filter(h -> !h.getKey().equals(user) & !friendsGraph.get(user).contains(h.getKey())) //user와 user 친구들 제외
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // 상위 점수대로 정렬
            .collect(Collectors.toList());

        return entries.subList(0, Math.min(entries.size(), 5)).stream().map(Map.Entry::getKey) //상위 5개 필터링
            .collect(Collectors.toList());
    }
}
