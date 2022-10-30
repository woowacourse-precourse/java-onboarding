package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> userPoints = makeUserPoints(user, friends, visitors);
        Map<String, List<String>> relationships = makeRelationShips(friends);
        List<String> userFriends = fillUserFriends(user, relationships);

        Map<String, Integer> friendPoints = enrichPointFrom(relationships, user, userFriends);

        return answer;
    }

    public static Map<String, Integer> enrichPointFrom(List<String> visitors, String user, List<String> userFriends) {
        Map<String, Integer> visitorPoints = new HashMap<>();

        for (String recommend : visitors) {
            visitorPoints.putIfAbsent(recommend, 0);
            visitorPoints.put(recommend, visitorPoints.get(recommend) + 1);
        }
        removeCantRecommendCase(user, userFriends, visitorPoints);
        return visitorPoints;
    }

    private static void removeCantRecommendCase(String user, List<String> userFriends, Map<String, Integer> points) {
        for (String friend : userFriends) {
            removeKey(points, friend);
        }
        removeKey(points, user);
    }

    private static void removeKey(Map<String, Integer> points, String friend) {
        if (!isEmptyValue(points, friend)) {
            points.remove(friend);
        }
    }

    private static boolean isEmptyValue(Map<String, ?> map, String key) {
        return map.get(key) == null;
    }

    public static Map<String, Integer> enrichPointFrom(Map<String, List<String>> relationships,
            String user, List<String> userFriends) {
        Map<String, Integer> friendPoints = new HashMap<>();
        for (String friend : userFriends) {
            for (String recommend : fillUserFriends(friend, relationships)) {
                friendPoints.putIfAbsent(recommend, 0);
                friendPoints.put(recommend, friendPoints.get(recommend) + 10);
            }
        }
        removeCantRecommendCase(user, userFriends, friendPoints);
        return friendPoints;
    }

    public static List<String> fillUserFriends(String user, Map<String, List<String>> relationships) {
        List<String> userFriend = relationships.get(user);
        return userFriend;
    }

    public static Map<String, List<String>> makeRelationShips(List<List<String>> friends) {
        Map<String, List<String>> relationships = new HashMap<>();
        for (List<String> friendRelation : friends) {
            enrichRelation(relationships, friendRelation.get(0), friendRelation.get(1));
            enrichRelation(relationships, friendRelation.get(1), friendRelation.get(0));
        }
        return relationships;
    }

    private static void enrichRelation(Map<String, List<String>> relationships, String f1, String f2) {
        if (isEmptyList(relationships.get(f1))) {
            relationships.put(f1, new ArrayList<>());
        }
        relationships.get(f1).add(f2);
    }

    private static boolean isEmptyList(List<String> list) {
        return list == null;
    }

    public static Map<String, Integer> makeUserPoints(String user, List<List<String>> friends,
            List<String> visitors) {
        Map<String, Integer> userList = new HashMap<String, Integer>();

        for (List<String> friendRelation : friends) {
            userList.put(friendRelation.get(0), 0);
            userList.put(friendRelation.get(1), 0);
        }

        for (String visitor : visitors) {
            userList.put(visitor, 0);
        }
        return userList;
    }
}
