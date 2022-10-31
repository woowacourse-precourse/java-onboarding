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

        Map<String, Integer> friendsScoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                continue;
            }

            for (String friendUser : friendUsers) {
                if (friend.contains(friendUser)) {
                    addTogetherKnowFriendsScore(friend, friendUser, friendsScoreMap);
                }
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

    private static void addTogetherKnowFriendsScore(List<String> friend, String friendUser, Map<String, Integer> friendsScoreMap) {
        for (int i = 0; i < friend.size(); i++) {
            if (!friend.get(i).equals(friendUser)) {
                friendsScoreMap.merge(friend.get(i), 10, (oldValue, newValue) -> oldValue + 10);
            }
        }
    }

}