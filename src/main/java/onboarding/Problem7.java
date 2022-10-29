package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> friendship = getFriendshipByFriends(friends);
        return answer;
    }

    private static Map<String, List<String>> getFriendshipByFriends(List<List<String>> friends) {
        Map<String, List<String>> friendship = new HashMap<>();
        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);
            friendship.putIfAbsent(idA, new ArrayList<>());
            friendship.putIfAbsent(idB, new ArrayList<>());
            friendship.get(idA).add(idB);
            friendship.get(idB).add(idA);
        }
        return friendship;
    }
}
