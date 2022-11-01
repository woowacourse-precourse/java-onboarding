package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    static Map<String, Integer> points;
    static String userName;
    static List<String> userFriendList;

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {

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
        visitors.stream().filter(visitor -> !userFriendList.contains(visitor)).forEach(
            Problem7::addVisitorPoint);
    }

    private static void addRelationPoints(List<String> recommendFriends) {
        recommendFriends.stream().forEach(Problem7::addRelationPoint);
    }

    private static List<String> getRecommendFriends(List<String> userFriendList,
        List<List<String>> friends) {

        return userFriendList.stream().map(friend -> getFriends(friend, friends))
            .flatMap(data -> data.stream())
            .filter(friend -> !userFriendList.contains(friend))
            .filter(friend -> !friend.equals(userName))
            .collect(Collectors.toList());
    }

    private static List<String> getFriends(String user, List<List<String>> friends) {
        return friends.stream().filter(friend -> friend.contains(user))
            .map(friend -> OnlyFriend(friend, user))
            .collect(Collectors.toList());

    }

    private static String OnlyFriend(List<String> s, String user) {
        if (s.get(0).equals(user)) {
            return s.get(1);
        }
        return s.get(0);
    }

    private static void addRelationPoint(String recommendFriend) {
        if (points.containsKey(recommendFriend)) {
            points.put(recommendFriend, points.get(recommendFriend) + 10);
        } else {
            points.put(recommendFriend, 10);
        }
    }

    private static void addVisitorPoint(String visitor) {
        if (points.containsKey(visitor)) {
            points.put(visitor, points.get(visitor) + 1);
        } else {
            points.put(visitor, 1);
        }
    }

    private static void sort(List<String> answer) {
        answer.sort((o1, o2) -> {
            if (points.get(o1) == points.get(o2)) {
                return o1.compareTo(o2);
            }
            return points.get(o2) - points.get(o1);
        });
    }

}
