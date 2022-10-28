package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> graph = new HashMap<>();
        Map<String, Integer> users = new HashMap<>();

        convertGraph(friends, graph);

        for (String key : graph.keySet()) {
            users.put(key, 0);
        }
        for (String s : graph.get(user)) {
            for (String s1 : graph.get(s)) {
                if (s1.equals(user)) continue;
                users.put(s1, users.get(s1) + 10);
            }
        }

        for (String visitor : visitors) {
            if (!users.containsKey(visitor)){
                users.put(visitor, 1);
            }else {
                users.put(visitor, users.get(visitor) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(users.entrySet());
        entryList.sort(((o1, o2) -> {
            if (users.get(o2.getKey()) == users.get(o1.getKey()))
                return o1.getKey().compareTo(o2.getKey());
            else
                return users.get(o2.getKey()) - users.get(o1.getKey());
        }));

        for (Map.Entry<String, Integer> entry : entryList) {
            if (answer.size() == 5) break;
            if (graph.get(user).contains(entry.getKey()) || entry.getValue() == 0) continue;
            answer.add(entry.getKey());
        }

        return answer;
    }

    private static void convertGraph(List<List<String>> friends, Map<String, ArrayList<String>> graph) {
        for (int i = 0; i < friends.size(); i++) {
            graph.put(friends.get(i).get(0), new ArrayList<>());
            graph.put(friends.get(i).get(1), new ArrayList<>());
        }
        for (int i = 0; i < friends.size(); i++) {
            graph.get(friends.get(i).get(0)).add(friends.get(i).get(1));
            graph.get(friends.get(i).get(1)).add(friends.get(i).get(0));
        }
    }
}
