package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> userFriends = new HashSet<>();
        HashMap<String, Integer> recommendFriends = new HashMap<>();
        for (List<String> friend : friends) {
            makeUserFriendList(userFriends ,friend, user);
        }
        for (List<String> friend : friends) {
            isAcquaintance(recommendFriends, friend, userFriends);
        }
        recommendFriends.remove(user);

        return answer;
    }

    public static void makeUserFriendList(Set<String> friendSet, List<String> friendship, String user) {
        if (friendship.get(0).equals(user)) {
            friendSet.add(friendship.get(1));
        }
        if (friendship.get(1).equals(user)) {
            friendSet.add(friendship.get(0));
        }
    }

    public static void isAcquaintance(HashMap<String, Integer> friendMap, List<String> friendship, Set<String> friendSet) {
        if (friendSet.contains(friendship.get(0))) {
            friendMap.put(friendship.get(1), friendMap.getOrDefault(friendship.get(1), 0) + 10);
        }
        if (friendSet.contains(friendship.get(1))) {
            friendMap.put(friendship.get(0), friendMap.getOrDefault(friendship.get(0), 0) + 10);
        }
    }
}
