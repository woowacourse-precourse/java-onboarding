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

        Map<String, Integer> friendsScoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                continue;
            }

            for (String userFriend : userFriends) {
                if (friend.contains(userFriend)) {
                    addKnowTogetherFriendsScore(friend, userFriend, friendsScoreMap);
                }
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

    private static void addKnowTogetherFriendsScore(List<String> friend, String userFriend, Map<String, Integer> friendsScoreMap) {
        for (String s : friend) {
            if (!s.equals(userFriend)) {
                friendsScoreMap.merge(s, 10, (oldValue, newValue) -> oldValue + 10);
            }
        }
    }
}
