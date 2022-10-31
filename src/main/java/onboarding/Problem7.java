package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static HashMap<String, List<String>> graph;
    public static Map<String, Integer> hashmap;

    public static void init(List<List<String>> friends) {
        graph = new HashMap<>();
        hashmap = new HashMap<>();
        for (List<String> friend : friends) {
            graph.put(friend.get(0), new ArrayList<>());
            graph.put(friend.get(1), new ArrayList<>());
        }
    }

    public static void makeGraph(List<List<String>> friends) {
        for (List<String> friend : friends) {
            graph.get(friend.get(0)).add(friend.get(1));
            graph.get(friend.get(1)).add(friend.get(0));
        }
    }

    public static void visit(String userName) {
        hashmap.put(userName, hashmap.getOrDefault(userName, 0) + 1);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init(friends);
        List<String> answer = new ArrayList<>();

        // 아는 친구 점수 ++
        makeGraph(friends);
        List<String> list = graph.get(user);
        for (String s : list) {
            List<String> list1 = graph.get(s);
            for (String s1 : list1) {
                hashmap.put(s1, hashmap.getOrDefault(s1, 0) + 10);
            }
        }

        // 방문자 점수 ++
        for (String visitor : visitors) {
            visit(visitor);
        }

        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            answer.add(entry.getKey());
        }

        Collections.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashmap.get(o1) == hashmap.get(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return hashmap.get(o2) - hashmap.get(o1);
                }
            }
        });


        return answer.stream().filter(i->i!=user).collect(Collectors.toList()).subList(0,3);
    }
}
