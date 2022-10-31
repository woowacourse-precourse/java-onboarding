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
