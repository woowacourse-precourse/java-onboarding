package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> friendsWithUser = new HashSet<>();

        friendsWithUser = checkUserFriends(user, friends, friendsWithUser);
        return answer;
    }

    public static Set<String> checkUserFriends(String user, List<List<String>> friends, Set<String> friendsWithUser) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                friendsWithUser.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                friendsWithUser.add(friends.get(i).get(0));
            } else {
                continue;
            }
        }
        return friendsWithUser;
    }
}
