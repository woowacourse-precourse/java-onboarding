package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getFriendsOfUser(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>(List.of());
        for (List<String> relation : friends) {
            String userA = relation.get(0);
            String userB = relation.get(1);

            if (userA.equals(user)) {
                friendsOfUser.add(userB);
            } else if (userB.equals(user)) {
                friendsOfUser.add(userA);
            }
        }
        return friendsOfUser;
    }
}
