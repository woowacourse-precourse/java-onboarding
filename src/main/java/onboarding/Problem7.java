package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendUsers = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                addFriendUsers(user, friend, friendUsers);
            }
        }
    }

    private static void addFriendUsers(String user, List<String> friend, List<String> friendUsers) {
        for (int i = 0; i < friend.size(); i++) {
            if (!friend.get(i).equals(user)) {
                friendUsers.add(friend.get(i));
            }
        }
    }
}