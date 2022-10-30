package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendsOfUser = findFriendsByUser(user, friends);

        return answer;
    }

    private static List<String> findFriendsByUser(String user, List<List<String>> friends) {
        Set<String> friendsOfUser = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    friendsOfUser.add(name);
                }
            }
        }
        friendsOfUser.remove(user);
        return new ArrayList<>(friendsOfUser);
    }
}
