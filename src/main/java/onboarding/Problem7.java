package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommendFriends = new HashMap<>();
        Set<String> userFriends = createUserFriendList(friends, user);
        for (List<String> friend : friends) {
            isAcquaintance(recommendFriends, friend, userFriends);
        }
        recommendFriends.remove(user);
        for (String v : visitors) {
            recommendVisitor(recommendFriends, v, userFriends);
        }
        return limitFiveLength(sortRecommendFriends(recommendFriends));
    }

    public static Set<String> createUserFriendList(List<List<String>> friends, String user) {
        Set<String> friendSet = new HashSet<>();
        for (List<String> f : friends) {
            addUserFriend(friendSet, f, user);
        }
        return friendSet;
    }

    public static void addUserFriend(Set<String> friendSet, List<String> friendship ,String user) {
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
    public static void recommendVisitor(HashMap<String, Integer> friendMap, String v, Set<String> friendSet) {
        if (!friendSet.contains(v)){
            friendMap.put(v, friendMap.getOrDefault(v, 0) + 1);
        }
    }

    public static List<List<String>> sortRecommendFriends(HashMap<String, Integer> friendMap) {
        List<List<String>> sortedList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : friendMap.entrySet()) {
            sortedList.add(List.of(entry.getKey(), Integer.toString(entry.getValue())));
        };
        sortedList.sort((List<String> a, List<String> b) -> {
            if (a.get(1).equals(b.get(1))) {
                return String.CASE_INSENSITIVE_ORDER.compare(a.get(0), b.get(0));
            }
            return -Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
        });
        return sortedList;
    }

    public static List<String> limitFiveLength(List<List<String>> list) {
        List<String> limitList = new ArrayList<>();
        for (List<String> s : list) {
            limitList.add(s.get(0));
        }
        return limitList;
    }
}
