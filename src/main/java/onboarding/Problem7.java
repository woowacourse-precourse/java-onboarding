package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> myFriends = new ArrayList<>();
        HashMap<String, Integer> graph = new HashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {
            String s1 = friends.get(i).get(0);
            String s2 = friends.get(i).get(1);
            if (s1 == user) myFriends.add(s2);
            else if (s2 == user) myFriends.add(s1);
        }
        for (int i = 0; i < friends.size(); i++) {
            String s1 = friends.get(i).get(0);
            String s2 = friends.get(i).get(1);
            if (s1 == user || s2 == user) continue;
            if (myFriends.contains(s1)) {
                graph.put(s2, graph.containsKey(s2) ? graph.get(s2) + 10 : 10);
            }
            if (myFriends.contains(s2)) {
                graph.put(s1, graph.containsKey(s1) ? graph.get(s1) + 10 : 10);
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String temp = visitors.get(i);
            if (myFriends.contains(temp)) continue;
            graph.put(temp, graph.containsKey(temp) ? graph.get(temp) + 1 : 1);
        }
        List<Map.Entry<String, Integer>> temp = new LinkedList<>(graph.entrySet());
        temp.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < 5; i++) {
            if (temp.size() <= i) break;
            answer.add(temp.get(i).getKey());
        }
        return answer;
    }
}