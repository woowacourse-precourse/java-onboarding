package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> alreadyFriends;
        Map<String, Integer> recommendFriend = new HashMap<>();

        alreadyFriends = getFriend(user, friends);
        getFriendScore(user, alreadyFriends, friends, recommendFriend);

        return answer;
    }

    public static void getVisitScore(List<String> visitors, Map<String, Integer> recommendFriend){
        for(String visitor : visitors){
            recommendFriend.put(visitor, recommendFriend.getOrDefault(visitor,0)+1);
        }
    }

    public static void getFriendScore(String user, List<String> alreadyFriends, List<List<String>> friends , Map<String,Integer> recommendFriend){
        for(String alreadyFriend : alreadyFriends) {
            for (List<String> friend : friends) {
                String firstHuman = friend.get(0);
                String secondHuman = friend.get(1);
                if(!(user.equals(firstHuman)||user.equals(secondHuman))) {
                    if (alreadyFriend.equals(firstHuman)) recommendFriend.put(secondHuman,10);
                    if (alreadyFriend.equals(secondHuman)) recommendFriend.put(firstHuman,10);
                }
            }
        }
    }

    public static List<String> getFriend(String user, List<List<String>> friends){
        List<String> alreadyFriend = new ArrayList<>();
        for(List<String> friend : friends){
            String firstHuman = friend.get(0);
            String secondHuman = friend.get(1);
            if(user.equals(firstHuman)) alreadyFriend.add(secondHuman);
            if(user.equals(secondHuman)) alreadyFriend.add(firstHuman);
        }
        return alreadyFriend;
    }
}
