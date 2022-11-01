package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    private static HashMap<String, Integer> pointList;
    private static HashMap<String, Set<String>> friendsList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        pointList = new HashMap<>();
        friendsList = new HashMap<>();

        createDirectFriends(friends, user);

        Set<String> userFriends = friendsList.get(user);
        for (Map.Entry<String, Integer> key : pointList.entrySet()) {
            scoreDirectFriends(key, userFriends);
        }

        for (String visitor : visitors) {
            if (!visitor.equals(user) && !friendsList.get(user).contains(visitor)) {
                scoreVisitedFriends(visitor);
            }
        }

        return pointList.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .filter(recommendFriend -> recommendFriend.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void scoreDirectFriends(Map.Entry<String, Integer> key, Set<String> userFriend) {
        int currentScore = 0;
        Set<String> currentFriends = friendsList.get(key.getKey());
        for (String userFriendName : userFriend) {
            if (currentFriends.contains(userFriendName)) {
                currentScore += 10;
            }
            key.setValue(currentScore);
        }
    }

    private static void scoreVisitedFriends(String friendName) {
        if (pointList.containsKey(friendName)) {
            pointList.replace(friendName, pointList.get(friendName) + 1);
        } else {
            pointList.put(friendName, 1);
        }
    }


    private static void createDirectFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            addToFriendsList(friendA, friendB, user);
            addToFriendsList(friendB, friendA, user);
        }
    }

    private static void addToFriendsList(String friendA, String friendB, String user) {
        if (!friendA.equals(user)) {
            pointList.put(friendA, 0);
        }
        if (!friendB.equals(user)) {
            pointList.put(friendB, 0);
        }
        if (!friendsList.containsKey(friendA)) {
            friendsList.put(friendA, new HashSet<>());
        }
        if (!friendsList.containsKey(friendB)) {
            friendsList.put(friendB, new HashSet<>());
        }

        friendsList.get(friendA).add(friendB);
        friendsList.get(friendB).add(friendA);
    }
}



