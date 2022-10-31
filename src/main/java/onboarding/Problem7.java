package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relations = new HashMap<>();
        setRelations(friends, relations);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void setRelations(List<List<String>> friends, Map<String, List<String>> relations) {
        for (List<String> friend : friends) {
            List<String> friend0List = relations.getOrDefault(friend.get(0), new ArrayList<>());
            List<String> friend1List = relations.getOrDefault(friend.get(1), new ArrayList<>());
            friend0List.add(friend.get(1));
            friend1List.add(friend.get(0));

            relations.put(friend.get(0), friend0List);
            relations.put(friend.get(1), friend1List);
        }
    }
}