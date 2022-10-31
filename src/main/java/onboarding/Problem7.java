package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        userFriends.add(user);

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (friend1.equals(user)) {
                userFriends.add(friend2);
            } else if (friend2.equals(user)) {
                userFriends.add(friend1);
            }
        }
        return userFriends;
    }
}
