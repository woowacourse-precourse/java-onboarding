package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static HashMap<String, HashSet<String>> constructGraph(List<List<String>> friends) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();

        for (List<String> friendRelationship: friends) {
            String idA = friendRelationship.get(0);
            String idB = friendRelationship.get(1);

            addEdge(graph, idA, idB);
            addEdge(graph, idB, idA);
        }
        return graph;
    }
    private static void addEdge(HashMap<String, HashSet<String>> graph, String userFrom, String userTo) {
        if (graph.containsKey(userFrom))
            graph.get(userFrom).add(userTo);
        else
            graph.put(userFrom, new HashSet<>(List.of(userTo)));
    }
    private static void scoreFriendOfFriend(HashMap<String, HashSet<String>> graph, HashMap<String, Integer> scoreMap, String user, String friend) {
        HashSet<String> friendList = graph.get(friend);
        HashSet<String> friendOfUser = graph.get(user);

        for (String friendOfFriend: friendList) {
            if (friendOfFriend.equals(user))
                continue;

            if (friendOfUser.contains(friendOfFriend))
                continue;

            int score = scoreMap.getOrDefault(friendOfFriend, 0);
            scoreMap.put(friendOfFriend, score + 10);
        }
    }
}