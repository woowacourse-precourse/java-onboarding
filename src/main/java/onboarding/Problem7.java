package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relation = getRelation(friends);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Map<String, List<String>> getRelation(List<List<String>> friends) {
        Map<String,List<String>> relation = new HashMap<>();
        for (List<String> twoFriends : friends) {
            putValue(relation, twoFriends);
        }
        return relation;
    }

    private static void putValue(Map<String, List<String>> relation, List<String> twoFriends) {
        if (!relation.containsKey(twoFriends.get(0)))
            relation.put(twoFriends.get(0), new ArrayList<>());
        if (!relation.containsKey(twoFriends.get(1)))
            relation.put(twoFriends.get(1), new ArrayList<>());
        relation.get(twoFriends.get(0)).add(twoFriends.get(1));
        relation.get(twoFriends.get(1)).add(twoFriends.get(0));
    }
}
