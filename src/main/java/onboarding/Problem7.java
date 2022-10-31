package onboarding;

import java.util.*;

public class Problem7 {

    private static void bfs(Map<String, List<String>> graph, Map<String, Integer> score, String startNode){
        //방문한 노드 List
        List<String> visited = new ArrayList<>();

        //방문 필요한 노드 List
        List<String> queue = new ArrayList<>();

        visited.add(startNode);
        queue.add(startNode);
        Integer level = 1;

        while(queue.size() > 0){
            for (int i = 0; i < queue.size(); i++) {
                //BFS는 큐의 구조를 갖는다.
                String node = queue.remove(0);

                if(level >= 2) score.put(node, 10); //TODO

                for (String key : graph.keySet()) {
                    //방문 리스트에 없는 노드면 추가
                    if(!visited.contains(key) && graph.get(node).contains(key)){
                        visited.add(key);
                        queue.add(key);
                    }
                }
            }
            level ++;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            if(graph.containsKey(friends.get(i).get(0))) graph.get(friends.get(i).get(0)).add(friends.get(i).get(1));
            else graph.put(friends.get(i).get(0), new ArrayList<>(Arrays.asList(friends.get(i).get(1))));

            if(graph.containsKey(friends.get(i).get(1))) graph.get(friends.get(i).get(1)).add(friends.get(i).get(0));
            else graph.put(friends.get(i).get(1), new ArrayList<>(Arrays.asList(friends.get(i).get(0))));
        }

        Map<String, Integer> score = new HashMap<>();
        bfs(graph, score, user);

        for (String i : visitors){
            if(graph.get(user).contains(i)) continue;
            if(score.containsKey(i)){
                Integer cnt = score.get(i) + 1;
                score.put(i, cnt);
            }
            else{
                score.put(i, 1);
            }
        }

        for (String i : score.keySet()){
            answer.add(i);
        }

        return answer;
    }
}
