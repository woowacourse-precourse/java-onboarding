package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relations = new HashMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        setRelations(friends, relations);
        calCloseFriendScore(user, relations, scoreMap);
        calVisitorsScore(visitors, scoreMap);
        removeOriginFriend(user, relations, scoreMap);

        return scoreMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void setRelations(List<List<String>> friends, Map<String, List<String>> relations) {
        for (List<String> friend : friends) {
            List<String> friend0List = relations.getOrDefault(friend.get(0), new ArrayList<>());
            List<String> friend1List = relations.getOrDefault(friend.get(1), new ArrayList<>());
            friend0List.add(friend.get(1));
            friend1List.add(friend.get(0));

            relations.put(friend.get(0), friend0List);
            relations.put(friend.get(1), friend1List);
        }
    }

    private static void calCloseFriendScore(String user, Map<String, List<String>> relations, Map<String, Integer> scoreMap) {
        List<String> userFriends = relations.get(user);
        for (String userFr : userFriends) {
            List<String> closeFriends = relations.get(userFr); // 친구의 친구 목록
            for (String closeFr : closeFriends) {
                scoreMap.put(closeFr, scoreMap.getOrDefault(closeFr, 0) + 10); // 10점 더하기
            }
        }
    }

    private static void calVisitorsScore(List<String> visitors, Map<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1); // 1점 더하기
        }
    }

    private static void removeOriginFriend(String user, Map<String, List<String>> relations, Map<String, Integer> scoreMap) {
        scoreMap.remove(user);
        List<String> userFriends = relations.get(user);
        for (String friend : userFriends) {
            scoreMap.remove(friend);
        }
    }

}