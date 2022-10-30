package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends;

        userFriends = getUserFriends(user, friends);
        System.out.println(userFriends);

        return answer;
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            int friendIndex = friend.indexOf(user);

            if (friendIndex == 0) {
                userFriends.add(friend.get(1));
            } else if (friendIndex == 1) {
                userFriends.add(friend.get(0));
            }
        }

        return userFriends;
    }
}
