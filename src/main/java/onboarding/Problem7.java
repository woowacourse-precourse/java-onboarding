package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, List<String>> getFriendMap(List<List<String>> friends) {
        Map<String, List<String>> friendMap = new HashMap<>();
        for (List<String> friendPair : friends) {
            List<String> friend1 = friendMap.getOrDefault(friendPair.get(0), new ArrayList<>());
            List<String> friend2 = friendMap.getOrDefault(friendPair.get(1), new ArrayList<>());
            friend1.add(friendPair.get(1));
            friend2.add(friendPair.get(0));
            friendMap.put(friendPair.get(0), friend1);
            friendMap.put(friendPair.get(1), friend2);
        }
        return friendMap;
    }
}
