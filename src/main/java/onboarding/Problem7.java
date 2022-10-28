package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<Integer, Integer> weight = new HashMap<>();
    private static HashMap<String, Integer> uniqueIDs = new HashMap<>();
    private static int forID = 0;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void setDistinctID(List<String> friends) { // getDistinctFriends 이후 호출됨
        for (int i = 0; i < friends.size(); i++) {
            String name = friends.get(i);
            uniqueIDs.put(name, forID++);
        }
    }
    public static List<String> getDistinctFriends(List<List<String>> friends) {
        List<String> forJoin = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);
            forJoin.addAll(relation);
        }
        Set<String> distinctSet = new HashSet<>(forJoin);
        List<String> distinctList = new ArrayList<>(distinctSet);
        return distinctList;
    }
}
