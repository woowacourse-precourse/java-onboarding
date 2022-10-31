package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendOfFriend = findFriendOfFriend(user, friends);
        Map<String, Integer> scoreRecommendFriendMap = getScoreRecommendFriend(friendOfFriend, visitors);
        List<String> sortedRecommendFriendList = getSortedRecommendFriend(scoreRecommendFriendMap);

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

    private static Map<String, Integer> getScoreRecommendFriend(List<String> friendOfFriend, List<String> visitors) {
        Map<String, Integer> resultScoreRecommendFriend = new TreeMap<>();

        friendOfFriend.forEach(friend -> {
            resultScoreRecommendFriend.put(friend, 10);
        });

        visitors.forEach(visitor -> {
           resultScoreRecommendFriend.putIfAbsent(visitor, 0);
           resultScoreRecommendFriend.put(visitor, resultScoreRecommendFriend.get(visitor) + 1);
        });

        return resultScoreRecommendFriend;
    }

    private static List<String> getSortedRecommendFriend(Map<String, Integer> scoreRecommendFriendMap) {
        List<String> result = scoreRecommendFriendMap.keySet().stream().sorted((user1, user2) -> {
            if (!Objects.equals(scoreRecommendFriendMap.get(user1), scoreRecommendFriendMap.get(user2))) {
                return scoreRecommendFriendMap.get(user2).compareTo(scoreRecommendFriendMap.get(user1));
            } else {
                return user1.compareTo(user2);
            }
        }).collect(Collectors.toList());

        return result;
    }
}
