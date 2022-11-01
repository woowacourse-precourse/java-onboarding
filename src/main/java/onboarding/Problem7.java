package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendScore = new HashMap<>();
        friendScore = initUserMap(friendScore, friends, visitors);
        List<String> userFriend = findUserFriend(user, friends);
        List<String> friendOfFriend = getFriendOfFriend(userFriend, friends);
        friendScore = getScore(friendOfFriend, visitors, friendScore);
        return getRecommendFriends(friendScore, user, userFriend);
    }

    public static Map<String, Integer> initUserMap(Map<String, Integer> map, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend: friends) {
            map.put(friend.get(0), 0);
            map.put(friend.get(1), 0);
        }
        for (String visitor: visitors) {
            map.put(visitor, 0);
        }
        return map;
    }
    public static List<String> findUserFriend(String user, List<List<String>>friends) {
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend: friends) {
            if (friend.get(0).equals(user)) userFriend.add(friend.get(1));
            if (friend.get(1).equals(user)) userFriend.add(friend.get(0));
        }
        return userFriend;
    }

    public static List<String> getFriendOfFriend(List<String> userFriend, List<List<String>> friends) {
        List<String> friendOfFriend = new ArrayList<>();

        for (List<String> friend: friends){
            for (String myFriend: userFriend) {
                if (friend.get(0).equals(myFriend)) friendOfFriend.add(friend.get(1));
                if (friend.get(1).equals(myFriend)) friendOfFriend.add(friend.get(0));
            }
        }
        return friendOfFriend;
    }

    public static Map<String, Integer> getScore(List<String> friendOfFriend, List<String> visitors, Map<String, Integer> friendScore) {
        for (String friend: friendOfFriend) {
            int prevScore = friendScore.get(friend);
            friendScore.put(friend, prevScore+10);
        }
        for (String visitor: visitors) {
            int prevScore = friendScore.get(visitor);
            friendScore.put(visitor, prevScore+1);
        }
        return friendScore;
    }

    public static List<String> getRecommendFriends(Map<String, Integer> friendScore, String user, List<String> userFriend) {
        friendScore.remove(user);
        for (String friend: userFriend) friendScore.remove(friend);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(friendScore.entrySet());
        List<String> recommendFriends = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (i == 5) break;
            recommendFriends.add(entry.getKey());
            i++;
        }
        return recommendFriends;
    }
}