package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommendFriends = new HashMap<>();
        Set<String> userFriends = new HashSet<>();

        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);
            userFriends.add(idA);
            if (!idB.equals(user)) {
                addKnowFriendScore(recommendFriends, idB);
            }
        }

        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                addVisitorScore(recommendFriends, visitor);
            }
        }


        return answer;
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
