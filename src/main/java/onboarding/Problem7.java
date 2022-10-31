package onboarding;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommendFriendsCandidate = new HashMap<>();
        Set<String> userFriends = new HashSet<>();

        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);
            userFriends.add(idA);
            if (!idB.equals(user)) {
                addKnowFriendScore(recommendFriendsCandidate, idB);
            }
        }

        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                addVisitorScore(recommendFriendsCandidate, visitor);
            }
        }

        return recommendFriendsCandidate.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    private static void addKnowFriendScore(HashMap<String, Integer> recommendFriends, String id) {
        if (recommendFriends.containsKey(id)) {
            recommendFriends.put(id, recommendFriends.get(id) + 10);
        } else {
            recommendFriends.put(id, 10);
        }
    }

    private static void addVisitorScore(HashMap<String, Integer> recommendFriends, String id) {
        if (recommendFriends.containsKey(id)) {
            recommendFriends.put(id, recommendFriends.get(id) + 1);
        } else {
            recommendFriends.put(id, 1);
        }
    }
}
