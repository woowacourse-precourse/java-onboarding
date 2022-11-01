package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    static Map<String, List<String>> friendsList;
    static Map<String, Integer> scores = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsList = searchFriends(friends);

        initScoresByOtherUser();
        initScoresByVisitors(visitors);

        searchUsersFriends(user);
        calculateVisitScore(visitors, user);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());
        sortList(entries);

        List<String> answer = new ArrayList<>();
        recommendFriend(entries, answer);

        return answer;
    }

    static Map<String, List<String>> searchFriends(List<List<String>> friends) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String from = friends.get(i).get(0);
            String to = friends.get(i).get(1);

            searchFriendsException(map, from);
            searchFriendsException(map, to);

            map.get(from).add(to);
            map.get(to).add(from);
        }

        return map;
    }

    static void searchFriendsException(Map<String, List<String>> map, String target) {
        if (map.containsKey(target)) {
            return;
        }

        map.put(target, new ArrayList<>());
    }

    static void initScoresByOtherUser() {
        for (String otherUser : friendsList.keySet()) {
            scores.put(otherUser, 0);
        }
    }

    static void initScoresByVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            scores.put(visitor, 0);
        }
    }

    static void searchUsersFriends(String user) {
        for (int index = 0; index < friendsList.get(user).size(); index++) {
            searchTarget(user, index);
        }
    }

    static void searchTarget(String user, int index) {
        String friend = friendsList.get(user).get(index);

        for (String target : friendsList.keySet()) {
            searchFriendsException(user, friend, target);
        }
    }

    static void searchFriendsException(String user, String friend, String target) {
        if (target.equals(user)) {
            return;
        }

        if (friendsList.get(user).contains(target)) {
            return;
        }

        searchFriends(friend, target);
    }

    static void searchFriends(String friend, String target) {
        for (int index = 0; index < friendsList.get(target).size(); index++) {
            calculateAcquaintanceScore(friend, target, index);
        }
    }

    static void calculateAcquaintanceScore(String friend, String target, int index) {
        if (friendsList.get(target).get(index).equals(friend)) {
            scores.put(target, scores.get(target) + 10);
        }
    }

    static void calculateVisitScore(List<String> visitors, String user) {
        for (String visitor : visitors) {
            CalculateVisitScoreException(user, visitor);
        }
    }

    static void CalculateVisitScoreException(String user, String visitor) {
        if (friendsList.get(user).contains(visitor)) {
            return;
        }

        scores.put(visitor, scores.get(visitor) + 1);
    }

    static void sortList(List<Map.Entry<String, Integer>> entries) {
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                }

                if(o1.getValue() == o2.getValue()) {
                    if (o1.getKey().charAt(0) > o2.getKey().charAt(0)) {
                        return 1;
                    }

                    return -1;
                }

                return -1;
            }
        });
    }

    static void recommendFriend(List<Map.Entry<String, Integer>> entries, List<String> recommendedList) {
        for (Map.Entry<String, Integer> entry : entries) {
            recommendFriendException(entry, recommendedList);
        }
    }

    static void recommendFriendException(Map.Entry<String, Integer> entry, List<String> recommendedList) {
        if (entry.getValue() == 0) {
            return;
        }

        if (recommendedList.size() > 5) {
            return;
        }

        recommendedList.add(entry.getKey());
    }
}
