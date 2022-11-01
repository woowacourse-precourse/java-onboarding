package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> getUserFriendsList(String user, List<List<String>> friends) {
        List<String> userFriendsList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (Objects.equals(friend.get(0), user)) {
                userFriendsList.add(friend.get(1));
            }
            if (Objects.equals(friend.get(1), user)) {
                userFriendsList.add(friend.get(0));
            }
        }
        return userFriendsList;
    }
}
