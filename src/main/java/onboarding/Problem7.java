package onboarding;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommendFriends = new HashMap<>();
        Set<String> getFriends = new HashSet<>();

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            getFriends.add(friendA);
            if (!friendB.equals(user)) {
                addAcquaintance(recommendFriends, friendB);
            }
        }

        for (String visitor : visitors) {
            if (!getFriends.contains(visitor)) {
                addVisitor(recommendFriends, visitor);
            }
        }

        return recommendFriends.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    private static void addAcquaintance(HashMap<String, Integer> recommendFriends, String id) {
        if (recommendFriends.containsKey(id)) {
            recommendFriends.put(id, recommendFriends.get(id) + 10);
        } else {
            recommendFriends.put(id, 10);
        }
    }

    private static void addVisitor(HashMap<String, Integer> recommendFriends, String id) {
        if (recommendFriends.containsKey(id)) {
            recommendFriends.put(id, recommendFriends.get(id) + 1);
        } else {
            recommendFriends.put(id, 1);
        }
    }
}