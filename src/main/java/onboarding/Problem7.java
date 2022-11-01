package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    private static List<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        initUserFriends(user, friends);
        return answer;
    }

    private static void initUserFriends(String user, List<List<String>> friends) {
        userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
    }
}