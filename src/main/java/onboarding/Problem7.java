package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    private static List<String> myFriendsList = new ArrayList<>();
    private static List<List<String>> notFriendsList = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> score = new HashMap<>();

        if (isError(user, friends, visitors)) {
            return List.of("-1");
        }

        divideFriends(user, friends);
        score = giveScore(friends, visitors, score);
        return answer;
    }

    public static Map<String, Integer> giveScore(List<List<String>> friends, List<String> visitors, Map<String, Integer> score) {
        for (String myFriend : myFriendsList) {
            for (List<String> notFriend : notFriendsList) {
                if (notFriend.contains(myFriend)) {
                    String id = "";
                    if (notFriend.get(0).equals(myFriend)) {
                        id = notFriend.get(1);
                    } else {
                        id = notFriend.get(0);
                    }
                    score.put(id, score.getOrDefault(id, 0) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (!myFriendsList.contains(visitor)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
        return score;
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
