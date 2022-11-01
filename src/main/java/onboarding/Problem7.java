package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> allFriends = getAllFriends(friends);
        List<String> userFriends = allFriends.get(user);

        Map<String, Integer> scoreMap = new HashMap<>();

        List<String> friendOfFriends = new LinkedList<>();
        for (String userFriend : userFriends) {
            List<String> recommendedFriends = allFriends.get(userFriend);
            friendOfFriends.addAll(recommendedFriends);
        }

        addScoreToFriendOfFriends(scoreMap, friendOfFriends);
        addScoreToVisitors(scoreMap, visitors);

        excludeFromScoreMap(scoreMap, user, userFriends);

        return answer;
    }

    private static Map<String, List<String>> getAllFriends(List<List<String>> friends) {
        Map<String, List<String>> members = new HashMap<>();
        for (List<String> relation : friends) {
            members.put(relation.get(0), members.getOrDefault(relation.get(0), new LinkedList<>()));
            members.get(relation.get(0)).add(relation.get(1));
            members.put(relation.get(1), members.getOrDefault(relation.get(1), new LinkedList<>()));
            members.get(relation.get(1)).add(relation.get(0));
        }

        return members;
    }

    private static void addScoreToVisitors(Map<String, Integer> score, List<String> visitors) {
        for (String visitor : visitors) {
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }
    }

    private static void addScoreToFriendOfFriends(Map<String, Integer> score, List<String> friendOfFriends) {
        for (String friendOfFriend : friendOfFriends) {
            score.put(friendOfFriend, score.getOrDefault(friendOfFriend, 0) + 10);
        }
    }

    private static void excludeFromScoreMap(Map<String, Integer> scoreMap, String user, List<String> userFriends) {
        scoreMap.remove(user);
        for (String uf : userFriends) {
            scoreMap.remove(uf);
        }
    }
}
