package onboarding;

import java.util.*;

public class Problem7 {

    public static void computeScoreVisitFriends(String user, Set<String> userFriends, Map<String, List<String>> relation, Map<String, Integer> recommendedFriedScore) {
        for(String userFriend : userFriends) {
            for(String notFriend : relation.get(userFriend)) {
                if(!notFriend.equals(user) && !userFriend.contains(notFriend)) {
                    recommendedFriedScore.put(notFriend, 10);
                }
            }
        }
    }

    public static void computeScoreKnowFriends(List<String> visitors, Set<String> userFriends, Map<String, Integer> recommendedFriedScore) {
        for(String visitor : visitors) {
            if(!userFriends.contains(visitor)) {
                if(recommendedFriedScore.containsKey(visitor)) {
                    int score = recommendedFriedScore.get(visitor) + 1;
                    recommendedFriedScore.put(visitor, score);
                } else {
                    recommendedFriedScore.put(visitor, 1);
                }
            }
        }
    }

    public static Map<String, List<String>> createRelation(List<List<String>> friends) {
        Map<String, List<String>> relation = new HashMap<>();

        for(List<String> friend : friends) {
            String id1 = friend.get(0);
            String id2 = friend.get(1);

            if(relation.containsKey(id1)) {
                relation.get(id1).add(id2);
            } else {
                relation.put(id1, new ArrayList<>(Arrays.asList(id2)));
            }

            if(relation.containsKey(id2)) {
                relation.get(id2).add(id1);
            } else {
                relation.put(id2, new ArrayList<>(Arrays.asList(id1)));
            }
        }
        return relation;
    }

    public static List<String> findRecommendedFriends(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendedFriedScore = new HashMap<>();
        Map<String, List<String>> relation = createRelation(friends);
        Set<String> userFriends = Set.copyOf(relation.get(user));

        computeScoreVisitFriends(user, userFriends, relation, recommendedFriedScore);
        computeScoreKnowFriends(visitors, userFriends, recommendedFriedScore);

        return new ArrayList<>(recommendedFriedScore.keySet());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        return findRecommendedFriends(user, friends, visitors);
    }
}
