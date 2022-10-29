package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Set<String>> friendMap;
    private static Map<String, Integer> scores;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friendMap = new HashMap<>();
        scores = new HashMap<>();

        makeFriendMap(friends);

        return answer;
    }

    private static void makeFriendMap(List<List<String>> friends) {
        for(List<String> relation : friends) {
            String n1 = relation.get(0);
            String n2 = relation.get(1);

            friendMap.putIfAbsent(n1, new HashSet<>());
            friendMap.get(n1).add(n2);

            friendMap.putIfAbsent(n2, new HashSet<>());
            friendMap.get(n2).add(n1);
        }
    }
}
