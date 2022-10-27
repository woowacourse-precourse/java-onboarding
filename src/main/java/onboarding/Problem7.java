package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static final String RELATED = "related";
    public static final String VISITED = "visited";
    public static final int RELATED_SCORE = 10;
    public static final int VISITED_SCORE = 1;
    public static final int RECOMMEND_COUNT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> friendList = generateFriendList(friends);
        List<String> relatedUserList = generateRelatedUser(friends, user);
        List<String> unknownVisitors = exceptFriend(visitors, friendList);
        Map<String, Integer> scoreMap = generateScoreMap(relatedUserList, unknownVisitors);
        List<String> sortedUserList = sortScoreMap(scoreMap);
        if (sortedUserList.size() <= RECOMMEND_COUNT) {
            return sortedUserList;
        }

        return pickHighScoreUser(sortedUserList);
    }

    private static Set<String> generateFriendList(List<List<String>> friends) {
        Set<String> friendList = new HashSet<>();
        for (List<String> friend : friends) {
            friendList.add(friend.get(0));
        }
        return friendList;
    }

    private static List<String> generateRelatedUser(List<List<String>> friends, String user) {
        List<String> relatedUserList = new ArrayList<>();
        for (List<String> friend : friends) {
            String userName = friend.get(1);
            if (!userName.equals(user)) {
                relatedUserList.add(userName);
            }
        }
        return relatedUserList;
    }

    private static List<String> exceptFriend(List<String> visitors, Set<String> friendList) {
        for (String friend : friendList) {
            visitors = visitors.stream()
                    .filter(v -> !v.equals(friend))
                    .collect(Collectors.toList());
        }
        return visitors;
    }

    private static Map<String, Integer> generateScoreMap(List<String> relatedUsers, List<String> visitors) {
        Map<String, Integer> relatedScoreMap = getScore(relatedUsers, RELATED);
        Map<String, Integer> visitedScoreMap = getScore(visitors, VISITED);

        relatedScoreMap.forEach((key, value) -> visitedScoreMap.merge(key, value, (v1, v2) -> v1 + v2));
        return visitedScoreMap;
    }

    private static Map<String, Integer> getScore(List<String> userList, String type) {
        int score = 0;
        Map<String, Integer> scoreMap = new HashMap<>();
        if (type.equals(RELATED)) {
            score = RELATED_SCORE;
        }

        if (type.equals(VISITED)) {
            score = VISITED_SCORE;
        }

        for (String user : userList) {
            scoreMap.put(user, scoreMap.getOrDefault(user, 0) + score);
        }

        return scoreMap;
    }

    private static List<String> sortScoreMap(Map<String, Integer> scoreMap) {
        List<String> nameList = new ArrayList<>(scoreMap.keySet());
        Collections.sort(nameList, (o1, o2) -> {
            if (scoreMap.get(o1) - scoreMap.get(o2) == 0) {
                return o1.compareTo(o2);
            }
            return scoreMap.get(o2).compareTo(scoreMap.get(o1));
        });
        return nameList;
    }

    private static List<String> pickHighScoreUser(List<String> userList) {
        return userList.subList(0, RECOMMEND_COUNT + 1);
    }
}
