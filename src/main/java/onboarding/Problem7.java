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

    private static HashMap<String, ArrayList<String>> createRelation(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> relationMap = new HashMap<>();

        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            relationMap = putRelation(relationMap, userA, userB);
            relationMap = putRelation(relationMap, userB, userA);
        }

        return relationMap;
    }


    private static HashMap<String, ArrayList<String>> putRelation(HashMap<String, ArrayList<String>> relationMap, String userA, String userB) {
        ArrayList<String> arrayList = new ArrayList<>();

        if (relationMap.containsKey(userA)) {
            arrayList = relationMap.get(userA);
        }
        arrayList.add(userB);
        relationMap.put(userA, arrayList);

        return relationMap;
    }
}
