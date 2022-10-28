package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = makeFriendsMap(friends, user);
    }

    private static Map<String, List<String>> makeFriendsMap(List<List<String>> friends, String user) {
        Map<String, List<String>> tmp = new HashMap<>();

        for (List<String> friend : friends) {
            tmp.computeIfAbsent(friend.get(0), s -> new ArrayList<>()).add(friend.get(1));
            tmp.computeIfAbsent(friend.get(1), s -> new ArrayList<>()).add(friend.get(0));
        }
        return tmp;
    }
}
