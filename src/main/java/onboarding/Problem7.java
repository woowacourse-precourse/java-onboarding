package onboarding;

import java.util.*;

public class Problem7 {
    static final int MAXRECOMMEND = 5;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new LinkedList<>();
        List<String> alreadyFriends;
        Map<String, Integer> recommendFriend = new HashMap<>();
        List<Map.Entry<String,Integer>> entryRecomFirends;


        alreadyFriends = getFriend(user, friends);
        getFriendScore(user, alreadyFriends, friends, recommendFriend);
        getVisitScore(alreadyFriends, visitors,recommendFriend);
        entryRecomFirends = sortByScoreAndName(recommendFriend);

        for(int idx = 0; idx<entryRecomFirends.size(); idx++){
            if(idx == MAXRECOMMEND) break;
            String recomFriend = entryRecomFirends.get(idx).getKey();
            answer.add(recomFriend);
        }
        return answer;
    }

    public static List<Map.Entry<String,Integer>> sortByScoreAndName(Map<String, Integer> recommendFriend){
        List<Map.Entry<String, Integer>> entryRecomFriends = new LinkedList<>(recommendFriend.entrySet());
        Collections.sort(entryRecomFriends, (o1, o2) -> {
            if(o2.getValue() > o1.getValue()) return 1;
            else if(o1.getValue() == o2.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }
            return -1;
        });
        return entryRecomFriends;
    }

    public static void getVisitScore(List<String> alreadyFriends, List<String> visitors, Map<String, Integer> recommendFriend){
        for(String visitor : visitors){
            if(!alreadyFriends.contains(visitor))
            recommendFriend.put(visitor, recommendFriend.getOrDefault(visitor,0)+1);
        }
    }

    public static void getFriendScore(String user, List<String> alreadyFriends, List<List<String>> friends , Map<String,Integer> recommendFriend){
        for(String alreadyFriend : alreadyFriends) {
            for (List<String> friend : friends) {
                String firstHuman = friend.get(0);
                String secondHuman = friend.get(1);
                if(!(user.equals(firstHuman)||user.equals(secondHuman))) {
                    if (alreadyFriend.equals(firstHuman) && !alreadyFriends.contains(secondHuman))
                        recommendFriend.put(secondHuman,recommendFriend.getOrDefault(secondHuman,0) + 10);
                    if (alreadyFriend.equals(secondHuman) && !alreadyFriends.contains(firstHuman))
                        recommendFriend.put(firstHuman,recommendFriend.getOrDefault(firstHuman,0) + 10);
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
