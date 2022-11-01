package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> findFriends(String user, List<List<String>> relationships) {
        List<String> currentFriends = new ArrayList<>();
        for (List<String> relationship : relationships) {
            if (!relationship.get(0).equals(user) && !relationship.get(1).equals(user))
                continue;
            if (relationship.get(0).equals(user)) {
                currentFriends.add(relationship.get(1));
                continue;
            }
            if (relationship.get(1).equals(user)) {
                currentFriends.add(relationship.get(0));
            }
        }
        return currentFriends;
    }

    static HashMap<String, Integer> calcFriendsScore(String user, List<String> currentFriends, List<List<String>> relationships) {
        HashMap<String, Integer> recommendationScoreMap = new HashMap<>();
        for (List<String> relationship : relationships) {
            for (String currentFriend : currentFriends) {
                if (relationship.get(0).equals(currentFriend) && !relationship.get(1).equals(user)) {
                    if (recommendationScoreMap.containsKey(relationship.get(1))) {
                        recommendationScoreMap.put(relationship.get(1), recommendationScoreMap.get(relationship.get(1)) + 10);
                        continue;
                    }
                    recommendationScoreMap.put(relationship.get(1), 10);
                }
                if (relationship.get(1).equals(currentFriend) && !relationship.get(0).equals(user)) {
                    if (recommendationScoreMap.containsKey(relationship.get(0))) {
                        recommendationScoreMap.put(relationship.get(0), recommendationScoreMap.get(relationship.get(0)) + 10);
                        continue;
                    }
                    recommendationScoreMap.put(relationship.get(0), 10);
                }
            }
        }
        return recommendationScoreMap;
    }

    static HashMap<String, Integer> calcVisitScore(List<String> currentFriends, List<String> visitors, HashMap<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            if (!currentFriends.contains(visitor)) {
                if (scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, scoreMap.get(visitor) + 1);
                    continue;
                }
                scoreMap.put(visitor, 1);
            }
        }
        return scoreMap;
    }

    static List<String> filterScore(HashMap<String, Integer> scoreMap) {
        List<String> names = new ArrayList<String>();
        List<Integer> scores = new ArrayList<Integer>();
        for (String k : scoreMap.keySet()) {
            if (scoreMap.get(k) != 0) {
                names.add(k);
                scores.add(scoreMap.get(k));
            }
        }
        List<String> sortedNames = sortNames(names, scores);
        if (sortedNames.size() > 5)
            return (sortedNames.subList(0, 5));
        return sortedNames;
    }

    static List<String> sortNames(List<String> names, List<Integer> scores){
        for (int i = 0; i < names.size(); i++) {
            for (int j = i + 1; j < names.size(); j++) {
                if (scores.get(i) < scores.get(j)) {
                    Collections.swap(scores, i, j);
                    Collections.swap(names, i, j);
                }
                if (scores.get(i) == scores.get(j)) {
                    if (names.get(i).compareTo(names.get(j)) > 0) {
                        Collections.swap(names, i, j);
                    }
                }
            }
        }
        return names;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> currentFriends = findFriends(user, friends);
        HashMap<String, Integer> recommendationScoreMap = calcVisitScore(currentFriends, visitors, calcFriendsScore(user, currentFriends, friends));
        return filterScore(recommendationScoreMap);
    }
}
