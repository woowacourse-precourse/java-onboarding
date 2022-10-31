package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = buildUserFriends(user, friends);
        Map<String, Integer> score = calcAcquaintanceScore(userFriends, friends);
        calcVisitorScore(score, visitors, userFriends);
        return calcRecommendFriend(score);
    }

    private static List<String> calcRecommendFriend(Map<String, Integer> score) {
        List<String> names = new ArrayList<>(score.keySet());
        names.sort((n1, n2) -> {
            if (score.get(n1).equals(score.get(n2))) {
                return n1.compareTo(n2);
            }
            return score.get(n2).compareTo(score.get(n1));
        });

        if (names.size() > 5) {
            names = names.subList(0, 5);
        }
        return names;
    }

    private static void calcVisitorScore(Map<String, Integer> score, List<String> visitors, Set<String> userFriends) {
        visitors.forEach(visitor -> {
            if (userFriends.contains(visitor)) {
                return;
            }
            if (!score.containsKey(visitor)) {
                score.put(visitor, 0);
            }
            score.put(visitor, score.get(visitor) + 1);
        });
    }

    private static Map<String, Integer> calcAcquaintanceScore(Set<String> userFriends, List<List<String>> friends) {
        Map<String, Integer> score = new HashMap<>();
        friends.forEach(relation -> {
            if (userFriends.contains(relation.get(0)) && !userFriends.contains(relation.get(1))) {
                if (!score.containsKey(relation.get(1))) {
                    score.put(relation.get(1), 0);
                }
                score.put(relation.get(1), score.get(relation.get(1)) + 10);
            }
            if (userFriends.contains(relation.get(1)) && !userFriends.contains(relation.get(0))) {
                if (!score.containsKey(relation.get(0))) {
                    score.put(relation.get(0), 0);
                }
                score.put(relation.get(0), score.get(relation.get(0)) + 10);
            }
        });
        return score;
    }

    private static Set<String> buildUserFriends(String user, List<List<String>> friends) {
        Set<String> ret = new HashSet<>();
        ret.add(user);

        friends.forEach(relation -> {
            if (relation.get(0).equals(user)) {
                ret.add(relation.get(1));
            }
            if (relation.get(1).equals(user)) {
                ret.add(relation.get(0));
            }
        });
        return ret;
    }
}
