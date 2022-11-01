package onboarding;

import java.util.*;

public class Problem7 {
    private static Map <String,Set <String>> friendsRelationMap;
    private static Map <String,Integer> recommendScoreMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        createFriendRelation(user, friends);
        relationScore(user);
        return null;
    }

    private static void relationScore(String user) {
        recommendScoreMap = new HashMap <>();

        for (String userFriend : friendsRelationMap.get(user)) {
            friendsRelationMap.get(userFriend).stream()
                    .filter(s -> !s.equals(user))
                    .forEach(s -> {
                        if (recommendScoreMap.containsKey(s)) {
                            recommendScoreMap.put(s, recommendScoreMap.getOrDefault(s, 10 + recommendScoreMap.get(s)));
                        }
                        recommendScoreMap.put(s, 10);
                    });
        }
    }

    private static void createFriendRelation(String user, List <List <String>> friends) {
        friendsRelationMap = new HashMap <>();

        for (List <String> relation : friends) {
            if (!friendsRelationMap.containsKey(relation.get(0))) {
                friendsRelationMap.put(relation.get(0), new HashSet <>());
            }

            if (!friendsRelationMap.containsKey(relation.get(1))) {
                friendsRelationMap.put(relation.get(1), new HashSet <>());
            }

            friendsRelationMap.get(relation.get(0)).add(relation.get(1));
            friendsRelationMap.get(relation.get(1)).add(relation.get(0));
        }
    }

}