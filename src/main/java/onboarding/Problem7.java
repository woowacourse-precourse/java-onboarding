package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> relation = new HashSet<>();
        Map<String, Integer> score = new HashMap<>();

        makeRelation(user, friends, relation);




        return answer;
    }

    public static void countFriend(String user, List<List<String>> friends, HashSet<String> relation, Map<String, Integer> score) {
        for (List<String> friend : friends) {
            String known = friend.get(0);
            String unknown = friend.get(1);
            if (known.equals(user) || unknown.equals(user)) {
                continue;
            }
            if (relation.contains(known) && relation.contains(unknown)) {
                continue;
            }
            if (relation.contains(known)) {
                if (score.containsKey(unknown)) {
                    score.put(unknown, score.get(unknown) + 10);
                    continue;
                }
                score.put(unknown, 10);
            }
            if (relation.contains(unknown)) {
                if (score.containsKey(known)) {
                    score.put(known, score.get(known) + 10);
                    continue;
                }
                score.put(known, 10);
            }
        }
    }

    public static void makeRelation(String user, List<List<String>> friends, HashSet<String> relation) {
        for (List<String> friend : friends) {
            String known = friend.get(0);
            String unknown = friend.get(1);
            if (known.equals(user)) {
                relation.add(known);
            }
            if (unknown.equals(user)) {
                relation.add(known);
            }
        }
    }
}
