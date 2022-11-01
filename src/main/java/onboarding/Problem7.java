package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> findFriends(String user, <List<List<String>> friends) {
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

    static HashMap<String, Integer> calcFriendsScore(String user, List<String> alreadyFriends, <List<List<String>> friends) {
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

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
