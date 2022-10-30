package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getTopFiveFriends(user, friends, visitors);
        return answer;
    }

    private static List<String> getTopFiveFriends(String user, List<List<String>> friends, List<String> visitors) {
        List<String> totalRecommendFriendsList = getRecommendScore(user, friends, visitors);
        List<String> result = new ArrayList<>();
        for(int i=0; i <totalRecommendFriendsList.size(); i++) {
            if(i == 5) break;
            result.add(totalRecommendFriendsList.get(i));
        }
        return result;
    }

    private static List<String> getRecommendScore(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> recommendScoreByEachFriend = getFriendScoreList(user, friends, visitors);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recommendScoreByEachFriend.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> value1, Map.Entry<String, Integer> value2) {
                return value2.getValue() - value1.getValue();
            }
        });

        for (Map.Entry<String,Integer> entry : entryList) {
            if(entry.getValue() == 0) continue;
            result.add(entry.getKey());
        }

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