package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void scoreCommonFriends(String user, Graph network, Map<String, Integer> idToScore) {
        Set<String> userFriends = network.getFriends(user);

        for (String friend : userFriends) {
            Set<String> commonFriends = network.getFriends(friend);
            plusScore(commonFriends, idToScore);
        }

        idToScore.remove(user);
    }

    private static void plusScore(Set<String> commonFriends, Map<String, Integer> idToScore) {
        for (String candidate : commonFriends) {
            int score = idToScore.getOrDefault(candidate, 0) + 10;
            idToScore.put(candidate, score);
        }
    }

    private static void scoreVisitors(String user, Graph network, List<String> visitors, Map<String, Integer> idToScore) {
        for (String visitor : visitors) {
            int score = idToScore.getOrDefault(visitor, 0) + 1;
            idToScore.put(visitor, score);
        }

        Set<String> userFriends = network.getFriends(user);
        for (String friend : userFriends) {
            idToScore.remove(friend);
        }
    }

}

class Graph {

    private final Map<String, Set<String>> adjLists;

    public Graph(List<List<String>> friends) {
        this.adjLists = new HashMap<>();

        for (int size = friends.size(), i = 0; i < size; i++) {
            List<String> relation = friends.get(i);
            String id1 = relation.get(0);
            String id2 = relation.get(1);
            setCompleteEdge(id1, id2);
        }
    }

    public void setCompleteEdge(String vertex1, String vertex2) {
        adjLists.putIfAbsent(vertex1, new HashSet<>());
        adjLists.putIfAbsent(vertex2, new HashSet<>());

        adjLists.get(vertex1)
                .add(vertex2);

        adjLists.get(vertex2)
                .add(vertex1);
    }

    public Set<String> getFriends(String id) {
        return adjLists.getOrDefault(id, Collections.emptySet());
    }

}