package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> recommendFriends = recommendList(user, friends, visitors);
        return recommendFriends;
    }

    public static List<String> createFriendList(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> members = new HashSet<>();
        userFriends = new HashSet<>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                if (name == user) {
                    if (j == 0) {
                        String userFriendR = friends.get(i).get(1);
                        userFriends.add(userFriendR);
                    }
                    if (j == 1) {
                        String userFriendL = friends.get(i).get(0);
                        userFriends.add(userFriendL);
                    }
                    continue;
                }
                members.add(name);
            }
        }
        for (String visitor : visitors) {
            members.add(visitor);
        }
        for (String userFriend : userFriends) {
            members.remove(userFriend);
        }
        List<String> friendList = new ArrayList<>(members);
        return friendList;
    }

    public static List<Integer> recommendPoint(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = createFriendList(user, friends, visitors);
        int[] friendRecommendPoint = new int[friendList.size()];

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                continue;
            }
            for (String userFriend : userFriends) {
                if (friends.get(i).contains(userFriend)) {
                    String friendL = friends.get(i).get(0);
                    String friendR = friends.get(i).get(1);
                    if (friendL == userFriend) {
                        int index = friendList.indexOf(friendR);
                        friendRecommendPoint[index] += 10;
                    }
                    if (friendR == userFriend) {
                        int index = friendList.indexOf(friendL);
                        friendRecommendPoint[index] += 10;
                    }
                }
            }
        }
        for (String visitor : visitors) {
            if (friendList.contains(visitor)) {
                int index = friendList.indexOf(visitor);
                friendRecommendPoint[index]++;
            }
        }
        List<Integer> recommendPointList = Arrays.stream(friendRecommendPoint).boxed().collect(Collectors.toList());
        return recommendPointList;
    }

    public static List<String> recommendList(String user, List<List<String>> friends, List<String> visitors) {
        List<Integer> recommendPointList = recommendPoint(user, friends, visitors);
        List<String> recommendFriends = new ArrayList<>();
        List<String> friendList = createFriendList(user, friends, visitors);

        for (int i = 0; i < recommendPointList.size(); i++) {
            int maxPoint = recommendPointList.get(i);
            for (int j = 0; j < recommendPointList.size(); j++) {
                if (recommendPointList.get(j) > maxPoint) {
                    maxPoint = recommendPointList.get(j);
                }
            }
            if (maxPoint == 0) {
                break;
            }
            for (int j = 0; j < recommendPointList.size(); j++) {
                if (recommendPointList.get(j) == maxPoint) {
                    String friendIndex = friendList.get(j);
                    recommendFriends.add(friendIndex);
                    recommendPointList.set(j, 0);
                    if (j == recommendPointList.size()) {
                        Collections.sort(recommendList(user, friends, visitors), Collections.reverseOrder());
                    }
                }
            }
        }
        return recommendFriends;
    }
}