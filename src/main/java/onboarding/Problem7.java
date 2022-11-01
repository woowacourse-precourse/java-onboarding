package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static final HashMap<String, ArrayList<String>> friendRelationship = new HashMap<>();
    static final HashMap<String, Integer> recommendationList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        if (!checkValidInput(user, friends, visitors)) {
            return Collections.emptyList();
        }

        connectFriends(friends);

        ArrayList<String> userFriends = friendRelationship.get(user);
        calculateRecommendScore(visitors, userFriends);

        return answer;
    }

    private static void calculateRecommendScore(List<String> visitors, ArrayList<String> userFriends) {
        userFriends.stream()
                .map(friendRelationship::get)
                .flatMap(Collection::stream)
                .forEach(friendOfFriend -> recommendationList.put(
                        friendOfFriend,
                        recommendationList.getOrDefault(friendOfFriend, 0) + 10));

        visitors.forEach(visitor ->
                recommendationList.put(visitor, recommendationList.getOrDefault(visitor, 0) + 1));
    }

    private static void connectFriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            if (!friendRelationship.containsKey(userA)) {
                friendRelationship.put(userA, new ArrayList<>());
            }
            if (!friendRelationship.containsKey(userB)) {
                friendRelationship.put(userB, new ArrayList<>());
            }

            friendRelationship.get(userA).add(userB);
            friendRelationship.get(userB).add(userA);
        }
    }

    private static boolean checkValidInput(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        if (friends.size() == 0 || friends.size() > 10000) {
            return false;
        }
        if (visitors.size() > 10000) {
            return false;
        }

        return true;
    }
}
