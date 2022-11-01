package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendRelationship = getFriendRelationship(friends);
        List<String> userFriends = friendRelationship.get(user);
        Map<String, Integer> scoreMap = new HashMap<>();
        List<String> friendsOfFriends = new ArrayList<>();

        for (String userFriend : userFriends) {
            friendsOfFriends.addAll(friendRelationship.get(userFriend));
        }

        addScoreToFriendOfFriends(scoreMap, friendsOfFriends);
        addScoreToVisitors(scoreMap, visitors);
        excludeFromScoreMap(scoreMap, user, userFriends);

        List<String> answer = sortByValue(scoreMap);

        return answer;
    }

    private static Map<String, List<String>> getFriendRelationship(List<List<String>> friends) {
        Map<String, List<String>> members = new HashMap<>();
        for (List<String> relation : friends) {
            members.put(relation.get(0), members.getOrDefault(relation.get(0), new ArrayList<>()));
            members.get(relation.get(0)).add(relation.get(1));
            members.put(relation.get(1), members.getOrDefault(relation.get(1), new ArrayList<>()));
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

    private static List<String> sortByValue(Map<String, Integer> score) {
        return score.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }
}
