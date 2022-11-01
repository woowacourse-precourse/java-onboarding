package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    static HashMap<String, ArrayList<String>> friendRelationship;
    static HashMap<String, Integer> recommendationList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendRelationship = new HashMap<>();
        recommendationList = new HashMap<>();

        if (!checkValidInput(user, friends, visitors)) {
            return Collections.emptyList();
        }

        connectFriends(friends);

        ArrayList<String> userFriends = friendRelationship.getOrDefault(user, new ArrayList<>());
        calculateFriendsScore(userFriends);
        calculateVisitScore(visitors);

        return recommendationList.keySet()
                .stream()
                .filter(otherUser -> recommendationList.get(otherUser) != 0)
                .filter(otherUser -> !userFriends.contains(otherUser) && !user.equals(otherUser))
                .sorted(Problem7::recommendPriority)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void calculateFriendsScore(ArrayList<String> userFriends) {
        if (userFriends.isEmpty()) {
            return;
        }

        List<String> friendOfFriend = userFriends.stream()
                .map(friendRelationship::get)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        for (String otherUser : friendOfFriend) {
            recommendationList.put(otherUser, recommendationList.getOrDefault(otherUser, 0) + 10);
        }
    }

    private static void calculateVisitScore(List<String> visitors) {
        for (String visitor : visitors) {
            recommendationList.put(visitor, recommendationList.getOrDefault(visitor, 0) + 1);
        }
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

    private static int recommendPriority(String userA, String userB) {
        int recommendScoreA = recommendationList.get(userA);
        int recommendScoreB = recommendationList.get(userB);

        if (recommendScoreA == recommendScoreB) {
            return userA.compareTo(userB);
        }

        return recommendScoreB - recommendScoreA;
    }
}
