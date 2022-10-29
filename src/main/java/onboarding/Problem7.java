package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    private static List<String> myFriendsList = new ArrayList<>();
    private static List<List<String>> notFriendsList = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        if (isError(user, friends, visitors)) {
            return List.of("-1");
        }

        divideFriends(user, friends);

        return answer;
    }

    private static void divideFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String id = "";
            if (friend.get(0).equals(user)) {
                id = friend.get(1);
            } else {
                id = friend.get(0);
            }

            if (friend.contains(user)) {
                myFriendsList.add(id);
            } else {
                notFriendsList.add(friend);
            }
        }
    }

    public static boolean isError(String user, List<List<String>> friends, List<String> visitors) {
        return checkUser(user) || checkFriends(friends) || checkVisitors(visitors);
    }

    public static boolean checkUser(String user) {
        return user.length() < 1 || user.length() > 30 || !user.matches("^[a-z]*$");
    }

    public static boolean checkFriends(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            return true;
        }
        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                return true;
            }
            if (friend.get(0).length() < 1 || friend.get(0).length() > 30 || friend.get(1).length() < 1 || friend.get(1).length() > 30) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkVisitors(List<String> visitors) {
        return visitors.size() > 10000;
    }
}
