package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                addUserFriends(user, friend, userFriends);
            }
        }

        return null;
    }

    private static void addUserFriends(String user, List<String> friend, List<String> userFriends) {
        for (String s : friend) {
            if (!s.equals(user)) {
                userFriends.add(s);
            }
        }
    }
}
