package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = createUserFriendList(friends, user);
        HashMap<String, Integer> recommendFriends = createRecommendList(friends, userFriends);
        isNotFriend(recommendFriends ,user);
        recommendVisitor(recommendFriends, visitors, userFriends);
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

    public static HashMap<String, Integer> createRecommendList(List<List<String>> friends, Set<String> friendSet) {
        HashMap<String, Integer> recommendMap = new HashMap<>();
        for (List<String> friend : friends) {
            updateRecommendFriend(recommendMap, friend, friendSet);
        }
        return recommendMap;
    }

    public static void updateRecommendFriend(HashMap<String, Integer> friendMap, List<String> friendship, Set<String> friendSet) {
        if (friendSet.contains(friendship.get(0))) {
            friendMap.put(friendship.get(1), friendMap.getOrDefault(friendship.get(1), 0) + 10);
        }
        if (friendSet.contains(friendship.get(1))) {
            friendMap.put(friendship.get(0), friendMap.getOrDefault(friendship.get(0), 0) + 10);
        }
    }

    public static void recommendVisitor(HashMap<String, Integer> friendMap, List<String> visitors, Set<String> friendSet) {
        for (String v : visitors) {
            addVisitorScore(friendMap, v, friendSet);
        }
    }

    public static void addVisitorScore(HashMap<String, Integer> friendMap, String visitor, Set<String> friendSet) {
        if (!friendSet.contains(visitor)){
            friendMap.put(visitor, friendMap.getOrDefault(visitor, 0) + 1);
        }
    }

    public static void isNotFriend(HashMap<String, Integer> recommendFriends, String user) {
        recommendFriends.remove(user);
    }

    public static List<List<String>> sortRecommendFriends(HashMap<String, Integer> friendMap) {
        List<List<String>> sortedList = new ArrayList<>();
        setSortList(sortedList, friendMap);
        sortedList.sort((List<String> a, List<String> b) -> {
            if (a.get(1).equals(b.get(1))) {
                return String.CASE_INSENSITIVE_ORDER.compare(a.get(0), b.get(0));
            }
            return -Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
        });
        return sortedList;
    }

    public static void setSortList(List<List<String>> list, HashMap<String, Integer> friendMap) {
        for (Map.Entry<String, Integer> entry : friendMap.entrySet()) {
            list.add(List.of(entry.getKey(), Integer.toString(entry.getValue())));
        }
    }

    public static List<String> limitFiveLength(List<List<String>> list) {
        List<String> limitList = new ArrayList<>();
        for (List<String> s : list) {
            limitList.add(s.get(0));
        }
        return limitList;
    }
}
