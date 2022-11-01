package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> graph = constructGraph(friends);
        HashSet<String> friendOfUser = graph.get(user);
        HashMap<String, Integer> scoreMap = new HashMap<>();

        for (String friend: friendOfUser)
            scoreFriendOfFriend(graph, scoreMap, user, friend);

        for (String visitor: visitors)
            scoreVisitedUser(graph, scoreMap, user, visitor);

        return selectTop5(scoreMap);
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
    private static void scoreVisitedUser(HashMap<String, HashSet<String>> graph, HashMap<String, Integer> scoreMap, String user, String visitor) {
        HashSet<String> friendOfUser = graph.get(user);

        if (visitor.equals(user))
            return;

        if (friendOfUser.contains(visitor))
            return;

        int score = scoreMap.getOrDefault(visitor, 0);
        scoreMap.put(visitor, score + 1);
    }
    private static ArrayList<String> selectTop5(HashMap<String, Integer> scoreMap) {
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue())
                    return 1;

                if (o1.getValue() < o2.getValue())
                    return -1;

                return o2.getKey().compareTo(o1.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry: scoreMap.entrySet()) {
            priorityQueue.add(entry);
            if (priorityQueue.size() > 5)
                priorityQueue.remove();
        }

        ArrayList<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty())
            result.add(priorityQueue.remove().getKey());

        Collections.reverse(result);
        return result;
    }
}