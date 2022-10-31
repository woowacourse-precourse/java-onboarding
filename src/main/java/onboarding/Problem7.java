package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendOfFriend = findFriendOfFriend(user, friends);
        answer = friendOfFriend;

        return answer;
    }

    private static List<String> findFriendOfFriend(String user, List<List<String>> friends) {
        Map<String, List<String>> adjacencyList = getAdjacencyList(friends);
        Map<String, Boolean> friendVisited = new TreeMap<>();
        Map<String, Integer> friendLevel = new TreeMap<>();
        Queue<String> friendQueue = new LinkedList<>();

        friendQueue.add(user);
        friendVisited.put(user, true);
        friendLevel.put(user, 0);

        while(!friendQueue.isEmpty()) {
            String person = friendQueue.poll();

            for(String friend : adjacencyList.get(person)) {
                if (!friendVisited.getOrDefault(friend, false)) {
                    friendVisited.put(friend, true);
                    friendLevel.put(friend, friendLevel.get(person) + 1);
                    friendQueue.add(friend);
                }
            }
        }

        List<String> resultTwoLevelFriend;
        resultTwoLevelFriend = friendLevel.keySet().stream()
                                .filter(friend -> friendLevel.get(friend) == 2)
                                .collect(Collectors.toList());

        return resultTwoLevelFriend;
    }

    private static Map<String, List<String>> getAdjacencyList(List<List<String>> friends) {
        Map<String, List<String>> resultAdjacencyList = new TreeMap<>();

        for(List<String> friend : friends) {
            String friendFirst = friend.get(0);
            String friendSecond = friend.get(1);

            if (!resultAdjacencyList.containsKey(friendFirst)) {
                resultAdjacencyList.put(friendFirst, new ArrayList<>());
            }
            resultAdjacencyList.get(friendFirst).add(friendSecond);

            if (!resultAdjacencyList.containsKey(friendSecond)) {
                resultAdjacencyList.put(friendSecond, new ArrayList<>());
            }
            resultAdjacencyList.get(friendSecond).add(friendFirst);
        }

        return resultAdjacencyList;
    }
}
