package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendObj = new HashMap<>();
        ArrayList<String> recommendFriends = new ArrayList<>();

        List<String> friendsList = friends.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        String friendA = "";
        String friendB = "";

        for (int i = 0; i < friendsList.size(); i = i + 2) {
            friendA = friendsList.get(i);
            friendB = friendsList.get(i+1);
            if (!Objects.equals(friendA, "") && Objects.equals(friendA, user)) recommendFriends.add(friendB);
            else if (!Objects.equals(friendB, "") && Objects.equals(friendB, user)) recommendFriends.add(friendA);
        }

        for (int i = 0; i < friendsList.size(); i = i + 2) {
            for (String recommendFriend : recommendFriends) {
                if (Objects.equals(friendsList.get(i), user) || Objects.equals(friendsList.get(i + 1), user)) continue;
                if (Objects.equals(friendsList.get(i), recommendFriend)) {
                    if (recommendObj.get(friendsList.get(i + 1)) == null)
                        recommendObj.put((friendsList.get(i + 1)), 10);
                    else if (recommendObj.get(friendsList.get(i + 1)) != null)
                        recommendObj.put(friendsList.get(i + 1), recommendObj.get(friendsList.get(i + 1)) + 10);
                } else if (Objects.equals(friendsList.get(i + 1), recommendFriend)) {
                    if (recommendObj.get(friendsList.get(i + 1)) == null)
                        recommendObj.put((friendsList.get(i)), 10);
                    else if (recommendObj.get(friendsList.get(i + 1)) != null)
                        recommendObj.put(friendsList.get(i), recommendObj.get(friendsList.get(i + 1)) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (recommendFriends.contains(visitor)) continue;
            if (recommendObj.get(visitor) == null)
                recommendObj.put(visitor, 1);
            else if (recommendObj.get(visitor) != null)
                recommendObj.put(visitor, (recommendObj.get(visitor)) + 1);
        }

        Set<String> result = recommendObj.keySet();
        return new ArrayList<>(result);
    }
}
