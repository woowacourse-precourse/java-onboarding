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

    private static HashMap<String, ArrayList<String>> registerRelationshipMap(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> relationshipMap = new HashMap<>();

        for (List<String> relation :
                friends) {
            for (int i = 0; i < 2; i++) {
                ArrayList<String> value;
                String person1 = relation.get(i);
                String person2 = relation.get(1 - i);

                if (relationshipMap.containsKey(person1)) {
                    value = relationshipMap.get(person1);
                } else {
                    value = new ArrayList<>();
                }

                value.add(person2);
                relationshipMap.put(person1, value);
            }
        }
        return relationshipMap;
    }
}
