package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> alreadyFriends = getAlreadyFriends(friends);

        return Arrays.asList("", "");
    }

    private static Set<String> getAlreadyFriends(List<List<String>> friends) {
        Set<String> alreadyFriends = new HashSet<>();

        for (List<String> friend : friends) {
            alreadyFriends.add(friend.get(0));
        }

        return alreadyFriends;
    }
}
