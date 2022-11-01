package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    static Set<String> userFriends = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        getFriends(user, friends);
        return answer;
    }

    public static void getFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0) == user) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1) == user) {
                userFriends.add(friend.get(0));
            }
        }
    }
}
