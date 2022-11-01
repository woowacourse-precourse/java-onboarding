package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends,
                                        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> userFriends = new HashSet<>();
        findUserFriends(user, friends, userFriends);
        return answer;
    }

    private static Set<String> findUserFriends(String user, List<List<String>> friends,
                                               Set<String> userFriends) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriends.add(friend.get(0));
                userFriends.add(friend.get(1));
            }
        }
        userFriends.remove(user);
        return userFriends;
    }
}
