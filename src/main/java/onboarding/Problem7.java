package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static HashMap<String, List<String>> getRelationMap(List<List<String>> friends) {
        HashMap<String, List<String>> relationMap = new HashMap<String, List<String>>();

        for (List<String> relation : friends) {
            String user1 = relation.get(0);
            String user2 = relation.get(1);

            if (!relationMap.containsKey(user1)) relationMap.put(user1, new ArrayList<>());
            if (!relationMap.containsKey(user2)) relationMap.put(user2, new ArrayList<>());

            relationMap.get(user1).add(user2);
            relationMap.get(user2).add(user1);
        }
        return relationMap;
    }
}
