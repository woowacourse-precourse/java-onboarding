package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, HashSet<String>> friendMap = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        fillFriendAndScoreMap(friends, friendMap, scoreMap);
        setRecommendScoreByVisit(visitors, scoreMap);
        setRecommendBySameFriends(user, friendMap, scoreMap);
        removeNotRecommendFriendInScoreMap(user, friendMap, scoreMap);
        sortScore(scoreMap);
        setFinalResultList(scoreMap, result);

        return answer;
    }

    private static void fillFriendAndScoreMap(List<List<String>> friends, HashMap<String, HashSet<String>> friendMap, HashMap<String, Integer> scoreMap) {
        for (List<String> friend : friends) {
            if (friendMap.containsKey(friend.get(0))) {
                HashSet<String> values = friendMap.get(friend.get(0));
                values.add(friend.get(1));
                friendMap.put(friend.get(0), values);
            } else {
                HashSet<String> values = new HashSet<>();
                values.add(friend.get(1));
                friendMap.put(friend.get(0), values);
                scoreMap.put(friend.get(0), 0);
            }

            if (friendMap.containsKey(friend.get(1))) {
                HashSet<String> values = friendMap.get(friend.get(1));
                values.add(friend.get(0));
                friendMap.put(friend.get(1), values);
            } else {
                HashSet<String> values = new HashSet<>();
                values.add(friend.get(0));
                friendMap.put(friend.get(1), values);
                scoreMap.put(friend.get(1), 0);
            }
        }
    }

        private static void setRecommendScoreByVisit(List<String> visitors, HashMap<String, Integer> scoreMap) {
            for (String friend : visitors) {
                if (scoreMap.containsKey(friend)) {
                    int score = scoreMap.get(friend);
                    scoreMap.put(friend, score + 1);
                } else {
                    scoreMap.put(friend, 0);
                }
            }
        }

    private static void setRecommendBySameFriends(String user, HashMap<String, HashSet<String>> friendMap, HashMap<String, Integer> scoreMap) {
        HashSet<String> userValues = friendMap.get(user);
        // System.out.println(user + "(" + userValues + ")");
        for (String friend : friendMap.keySet()) {
            HashSet<String> mapValues = friendMap.get(friend);
            // System.out.println(friend + "(" + mapValues + ")");

            if (userValues.equals(mapValues)) {
                int score = scoreMap.get(friend);
                scoreMap.put(friend, score + 10);
            }
        }
    }
    private static void removeNotRecommendFriendInScoreMap(String user,
        HashMap<String, HashSet<String>> friendMap, HashMap<String, Integer> scoreMap) {
        removeUserInScoreMap(user, scoreMap);
        removeExistFriendInScoreMap(user, friendMap, scoreMap);
    }

    private static void removeUserInScoreMap(String user, HashMap<String, Integer> scoreMap) {
        scoreMap.remove(user);
    }

    private static void removeExistFriendInScoreMap(String user,
                HashMap<String, HashSet<String>> friendMap,
                HashMap<String, Integer> scoreMap) {
        HashSet<String> existFriends = friendMap.get(user);
        for (String friend : existFriends) {
            scoreMap.remove(friend);
        }
    }

    private static  void sortScore(HashMap<String, Integer> scoreMap) {
        List<Map.Entry<String, Integer>> listEntry = new ArrayList<>(scoreMap.entrySet());
        listEntry.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() != o1.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
    }

    private static void setFinalResultList(HashMap<String, Integer> scoreMap, List<String> result) {
        int count = 0;
        List<Map.Entry<String, Integer>> listEntry = new ArrayList<>(scoreMap.entrySet());
        for (Map.Entry<String, Integer> entry : listEntry) {
            if (count == 5) {
                break;
            }
            if (entry.getValue() > 0) {
                result.add(entry.getKey());
            } else if (entry.getValue() == 0) {
                break;
            }

        }
    }
}

