package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Problem7 {
    static Map<String, Integer> points;
    static String userName;
    static List<String> userFriendList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init(user, friends, visitors);
        List<String> answer = new ArrayList<>(points.keySet());

        sort(answer);

        List<String> collect = answer.stream().limit(5).collect(Collectors.toList());
        return collect;
    }


    private static void init(String user, List<List<String>> friends, List<String> visitors) {
        points = new HashMap<>();
        userName = user;
        userFriendList = getFriends(userName, friends);
        addRelationPoints(getRecommendFriends(userFriendList, friends));
        addVisitorPoint(visitors);
    }

    private static void addVisitorPoint(List<String> visitors) {
        for (String visitor : visitors) {
            if (userFriendList.contains(visitor)) {
                continue;
            }
            if (points.containsKey(visitor)) {
                points.put(visitor, points.get(visitor) + 1);
            } else {
                points.put(visitor, 1);
            }

        }
    }

    private static void addRelationPoints(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (points.containsKey(list.get(i))) {
                points.put(list.get(i), points.get(list.get(i)) + 10);
            } else points.put(list.get(i), 10);
        }
    }

    private static List<String> getRecommendFriends(List<String> userFriendList, List<List<String>> friends) {
        List<String> recommendFriends = new ArrayList<>();
        for (String friend : userFriendList) {
            List<String> myFriendsFriends = getFriends(friend, friends);
            for (int i = 0; i < myFriendsFriends.size(); i++) {
                if (myFriendsFriends.get(i).equals(userName)) {
                    continue;
                }
                if (!userFriendList.contains(myFriendsFriends.get(i))) {
                    recommendFriends.add(myFriendsFriends.get(i));
                }
            }

        }
        return recommendFriends;
    }

    private static List<String> getFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List friend : friends) {
            if (friend.contains(user)) {
                friendList.add(OnlyFriend(friend, user));
            }
        }
        return friendList;
    }

    private static String OnlyFriend(List s, String user) {
        if (s.get(0).equals(user)) {
            return (String) s.get(1);
        }
        return (String) s.get(0);
    }

    private static void sort(List<String> answer) {
        answer.sort((o1, o2) -> {
            if (points.get(o1) < points.get(o2)) return 1;
            else if (points.get(o1) > points.get(o2)) return -1;
            else {
                if (points.get(o1) == points.get(o2)) {
                    return o1.compareTo(o2);
                }
            }
            return 0;
        });
    }
}
