package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> alreadyFriends = new ArrayList<>();
        for (List<String> relationship : friends) {
            if (!relationship.get(0).equals(user) && !relationship.get(1).equals(user))
                continue;
            if (relationship.get(0).equals(user)) {
                alreadyFriends.add(relationship.get(1));
                continue;
            }
            if (relationship.get(1).equals(user)) {
                alreadyFriends.add(relationship.get(0));
            }
        }
        return alreadyFriends;
    }

    static HashMap<String, Integer> calcFriendsScore(String user, List<String> alreadyFriends, List<List<String>> friends) {
        HashMap<String, Integer> score = new HashMap<>();
        for (List<String> relationship : friends) {
            for (String alreadyFriend : alreadyFriends) {
                if (relationship.get(0).equals(alreadyFriend)) {
                    if (!relationship.get(1).equals(user)) {
                        if (score.containsKey(relationship.get(1))) {
                            score.put(relationship.get(1), score.get(relationship.get(1)) + 10);
                            continue;
                        }
                        score.put(relationship.get(1), 10);
                    }
                }
                if (relationship.get(1).equals(alreadyFriend)) {
                    if (!relationship.get(0).equals(user)) {
                        if (score.containsKey(relationship.get(0))) {
                            score.put(relationship.get(0), score.get(relationship.get(0)) + 10);
                            continue;
                        }
                        score.put(relationship.get(0), 10);
                    }
                }
            }
        }
        return score;
    }

    static HashMap<String, Integer> calcVisitScore(List<String> alreadyFriends, List<String> visitors, HashMap<String, Integer> score) {
        for (String visitor : visitors) {
            if (!alreadyFriends.contains(visitor)) {
                if (score.containsKey(visitor)) {
                    score.put(visitor, score.get(visitor) + 1);
                    continue;
                }
                score.put(visitor, 1);
            }
        }
        return score;
    }

    static List<String> filterScore(HashMap<String, Integer> score) {
        List<String> keys = new ArrayList<String>();
        List<Integer> values = new ArrayList<Integer>();
        for (String k : score.keySet()) {
            if (score.get(k) != 0) {
                keys.add(k);
                values.add(score.get(k));
            }
        }
        //정렬
        for (int i = 0; i < keys.size(); i++) {
            for (int j = i + 1; j < keys.size(); j++) {
                if (values.get(i) < values.get(j)) {
                    Collections.swap(values, i, j);
                    Collections.swap(keys, i, j);
                }
            }
        }
        if (keys.size()>5)
            return(keys.subList(0,5));
        return keys;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> currentFriends = findFriends(user, friends);
        HashMap<String, Integer> recommendationScore = calcVisitScore(currentFriends, visitors, calcFriendsScore(user, currentFriends, friends));
        return filterScore(recommendationScore);
    }
}
