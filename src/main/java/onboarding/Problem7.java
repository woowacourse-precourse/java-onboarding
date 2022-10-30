package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getRecommendScore(user, friends, visitors);
        return answer;
    }

    private static List<String> getRecommendScore(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> recommendScoreByEachFriend = getFriendScoreList(user, friends, visitors);

        return result;
    }

    private static Map<String, Integer> getFriendScoreList(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendScoreByEachFriend = new TreeMap<>();
        
        recommendScoreByEachFriend = addKnownFriendScore(recommendScoreByEachFriend, user, friends);
        recommendScoreByEachFriend = addVisitorScore(recommendScoreByEachFriend, visitors);

        return recommendScoreByEachFriend;
    }

    private static Map<String, Integer> addKnownFriendScore(Map<String, Integer> recommendScoreByEachFriend, String user, List<List<String>> friends) {
        for (List<String> relation : friends) {
            if (relation.get(0) == user) {
                recommendScoreByEachFriend.put(relation.get(1), 0);
            } else if (relation.get(1) == user) {
                recommendScoreByEachFriend.put(relation.get(0), 0);
            } else {
                recommendScoreByEachFriend.put(relation.get(0), 10);
                recommendScoreByEachFriend.put(relation.get(1), 10);
            }
        }
        return recommendScoreByEachFriend;
    }

    private static Map<String, Integer> addVisitorScore(Map<String, Integer> recommendScoreByEachFriend, List<String> visitors) {
        for (String visitor : visitors) {
            if(recommendScoreByEachFriend.get(visitor) == null) {
                recommendScoreByEachFriend.put(visitor, 1);
            } else if(recommendScoreByEachFriend.get(visitor) == 0) {
                continue;
            } else {
                recommendScoreByEachFriend.put(visitor, recommendScoreByEachFriend.get(visitor) + 1);
            }
        }
        return recommendScoreByEachFriend;
    }
}