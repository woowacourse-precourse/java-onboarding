package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> userFriends = new ArrayList<>();


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        getUserFriends(user, friends);

    }

    private static void getUserFriends(String user, List<List<String>> friends) {
        for (List<String> friendship : friends) {
            if (friendship.get(0) == user) {
                userFriends.add(friendship.get(1));
            } else if (friendship.get(1) == user) {
                userFriends.add(friendship.get(0));
            }
        }
    }

}
