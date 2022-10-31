package onboarding;

import java.util.*;


public class Problem7 {
    private static final List<String> USER_FRIENDS = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        getUserFriends(user, friends);
        return new ArrayList<>();
    }

    private static void getUserFriends(String user, List<List<String>> friends) {
        for (List<String> info : friends) {
            String userA = info.get(0);
            String userB = info.get(1);

            if (userA.equals(user)) {
                USER_FRIENDS.add(userB);
            }
            if (userB.equals(user)) {
                USER_FRIENDS.add(userA);
            }
        }
    }
}
