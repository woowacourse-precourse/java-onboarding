package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend: friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if(user1.equals(user)) {
                userFriends.add(user2);
                continue;
            }
            if (user2.equals(user)) {
                userFriends.add(user1);
                continue;
            }
        }
    }
}
