package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, List<String>> makeFriendGraph(List<List<String>> friends) {
        Map<String, List<String>> relation = new HashMap<>();
        for (List<String> friend : friends) {
            String person1 = friend.get(0);
            String person2 = friend.get(1);
            if (!relation.containsKey(person1)) relation.put(person1, new ArrayList<String>(List.of(person2)));
            else relation.get(person1).add(person2);
            if (!relation.containsKey(person2)) relation.put(person2, new ArrayList<String>(List.of(person1)));
            else relation.get(person2).add(person1);
        }
        return relation;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
