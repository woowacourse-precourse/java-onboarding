package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    static HashMap<String, Integer> allUsersID = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void createUserFriendsList (String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user_A = friend.get(0);
            String user_B = friend.get(1);
            if (user.equals(user_A)) {
                userFriends.add(user_B);
            }
            if (user.equals(user_B)) {
                userFriends.add(user_A);
            }
        }
    }
}
