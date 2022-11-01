package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> friendRelationshipMap = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();

        getFriendRelationshipMap(user, friends, friendRelationshipMap, scoreMap);

        return answer;
    }

    private static void getFriendRelationshipMap(String user, List<List<String>> friends, HashMap<String, List<String>> friendRelationshipMap, HashMap<String, Integer> scoreMap) {
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            initializeScoreMap(user, scoreMap, userA, userB);

            if (friendRelationshipMap.containsKey(userA)) {
                friendRelationshipMap.get(userA).add(userB);
            } else {
                friendRelationshipMap.put(userA, new ArrayList<>(List.of(userB)));
            }

            if (friendRelationshipMap.containsKey(userB)) {
                friendRelationshipMap.get(userB).add(userA);
            } else {
                friendRelationshipMap.put(userB, new ArrayList<>(List.of(userA)));
            }
        }
    }

    private static void initializeScoreMap(String user, HashMap<String, Integer> scoreMap, String userA, String userB) {
        if (userA.equals(user) == false) {
            scoreMap.put(userA, 0);
        }

        if (userB.equals(user) == false) {
            scoreMap.put(userB, 0);
        }
    }
}
