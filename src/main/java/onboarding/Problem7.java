package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    private static final Set<String> friendsOfUserSet = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setFriends(friends, user);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void setFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (isFriendOfUser(friend, user)) {
                friendsOfUserSet.addAll(friend);
            }
        }
    }

    public static boolean isFriendOfUser(List<String> friend, String user) {
        return friend.contains(user);
    }
}
