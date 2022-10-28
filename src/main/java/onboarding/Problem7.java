package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> recommendFriend = new HashMap<>();

        getFriendsScore(user, friends, recommendFriend);

        return answer;
    }

    public static void getVisitScore(List<String> visitors, Map<String, Integer> recommendFriend){
        for(String visitor : visitors){
            recommendFriend.put(visitor, recommendFriend.getOrDefault(visitor,0)+1);
        }
    }

    public static void getFriendsScore(String user, List<List<String>> friends , Map<String,Integer> recommendFriend){
        for(List<String> friend : friends){
            String firstHuman = friend.get(0);
            String secondHuman = friend.get(1);
            if(user.equals(firstHuman)) recommendFriend.put(secondHuman,10);
            if(user.equals(secondHuman)) recommendFriend.put(firstHuman,10);
        }
    }
}
