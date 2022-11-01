package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int MAX_PRINT_FRIEND_LENGTH = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendOfUser = getFriendOfUser(user, friends);
        Map<String, Integer> friendOfFriend = getFriendOfFriend(user, friends);

        Map<String, Integer> scoreRecommendFriend = getScoreRecommendFriend(friendOfFriend, visitors);
        Map<String, Integer> refineScoreRecommendFriend
                = getRefineScoreRecommendFriend(scoreRecommendFriend, friendOfUser);

        List<String> sortedRecommendFriend = getSortedRecommendFriend(refineScoreRecommendFriend);
        List<String> fiveRecommendFriend = getFiveRecommendFriend(sortedRecommendFriend);

        answer = fiveRecommendFriend;

        return answer;
    }

    public static List<String> getFriendOfUser(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        friends.stream()
                .filter(friend -> friend.get(0).equals(user))
                .forEach(friend -> result.add(friend.get(1)));

        friends.stream()
                .filter(friend -> friend.get(1).equals(user))
                .forEach(friend -> result.add(friend.get(0)));

        return result;
    }

    private static Map<String, Integer> getFriendOfFriend(String user, List<List<String>> friends) {
        Map<String, List<String>> adjacencyList = getAdjacencyList(friends);
        Map<String, Integer> friendVisited = new TreeMap<>();
        Map<String, Integer> friendLevel = new TreeMap<>();
        Queue<String> friendQueue = new LinkedList<>();
        List<String> twoLevelFriend;
        Map<String, Integer> resultFriendOfFriend = new TreeMap<>();

        adjacencyList.putIfAbsent(user, new ArrayList<>());
        friendQueue.add(user);
        friendVisited.put(user, 1);
        friendLevel.put(user, 0);

        while(!friendQueue.isEmpty()) {
            String person = friendQueue.poll();

            for(String friend : adjacencyList.get(person)) {
                if (friendLevel.getOrDefault(person, 0) == 1
                        && friendLevel.getOrDefault(friend, 0) == 2) {
                    friendVisited.put(friend, friendVisited.get(friend) + 1);
                    continue;
                }

                if (friendVisited.getOrDefault(friend, 0) == 0) {
                    friendVisited.put(friend, 1);
                    friendLevel.put(friend, friendLevel.get(person) + 1);
                    friendQueue.add(friend);
                }
            }
        }

        twoLevelFriend = friendLevel.keySet().stream()
                .filter(friend -> friendLevel.get(friend) == 2)
                .collect(Collectors.toList());

        twoLevelFriend.forEach(friend -> {
            resultFriendOfFriend.put(friend, friendVisited.get(friend));
        });

        return resultFriendOfFriend;
    }

    private static Map<String, List<String>> getAdjacencyList(List<List<String>> friends) {
        Map<String, List<String>> resultAdjacencyList = new TreeMap<>();

        friends.forEach(friend -> {
            String friendFirst = friend.get(0);
            String friendSecond = friend.get(1);

            resultAdjacencyList.putIfAbsent(friendFirst, new ArrayList<>());
            resultAdjacencyList.get(friendFirst).add(friendSecond);

            resultAdjacencyList.putIfAbsent(friendSecond, new ArrayList<>());
            resultAdjacencyList.get(friendSecond).add(friendFirst);
        });

        return resultAdjacencyList;
    }

    private static Map<String, Integer> getScoreRecommendFriend(Map<String, Integer> friendOfFriend, List<String> visitors) {
        Map<String, Integer> resultScoreRecommendFriend = new TreeMap<>();;

        friendOfFriend.forEach((friend, count) -> {
            resultScoreRecommendFriend.putIfAbsent(friend, 0);
            resultScoreRecommendFriend.put(friend, resultScoreRecommendFriend.get(friend) + 10 * count);
        });

        visitors.forEach(visitor -> {
           resultScoreRecommendFriend.putIfAbsent(visitor, 0);
           resultScoreRecommendFriend.put(visitor, resultScoreRecommendFriend.get(visitor) + 1);
        });

        return resultScoreRecommendFriend;
    }

    private static Map<String, Integer> getRefineScoreRecommendFriend(
            Map<String, Integer> scoreRecommendFriend,
            List<String> friendOfUser) {
        Map<String, Integer> result = scoreRecommendFriend;

        for(String friend : friendOfUser) {
            result.remove(friend);
        }

        return result;
    }

    private static List<String> getSortedRecommendFriend(Map<String, Integer> scoreRecommendFriendMap) {
        List<String> result = scoreRecommendFriendMap.keySet()
                .stream()
                .sorted((user1, user2) -> {
                    int user1Score = scoreRecommendFriendMap.get(user1);
                    int user2Score = scoreRecommendFriendMap.get(user2);

                    if (!Objects.equals(user1Score, user2Score)) {
                        return Boolean.FALSE.compareTo(user1Score > user2Score);
                    } else {
                        return user1.compareTo(user2);
                    }})
                .collect(Collectors.toList());

        return result;
    }

    private static List<String> getFiveRecommendFriend(List<String> sortedRecommendFriend) {
        int maxLength = Math.min(sortedRecommendFriend.size(), MAX_PRINT_FRIEND_LENGTH);
        List<String> result = sortedRecommendFriend.subList(0, maxLength);

        return result;
    }
}
