package onboarding;

import java.util.*;

public class Problem7 {

    public static HashSet<String> makeFriendSet(String user, List<List<String>> friends) {
        HashSet<String> friendSet = new HashSet<>();
        for(int i = 0; i < friends.size(); i++)
        {
            if(friends.get(i).get(0).equals(user))
            {
                friendSet.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user))
            {
                friendSet.add(friends.get(i).get(0));
            }
        }
        return friendSet;
    }

    public static HashMap<String,Integer> knowWithUser(HashSet<String> friendSet, String user,
                                                       List<List<String>> friends) {
        HashMap<String,Integer> recommendFriendMap = new HashMap<>();
        for(int i = 0; i < friends.size(); i++)
        {
            if(friendSet.contains(friends.get(i).get(0)) && !friends.get(i).get(1).equals(user))
            {
                recommendFriendMap.put(friends.get(i).get(1),
                        recommendFriendMap.containsKey(friends.get(i).get(1))
                                ? recommendFriendMap.get(friends.get(i).get(1)) + 10 : 10);
            }
            else if(friendSet.contains(friends.get(i).get(1)) && !friends.get(i).get(0).equals(user))
            {
                recommendFriendMap.put(friends.get(i).get(0),
                        recommendFriendMap.containsKey(friends.get(i).get(0))
                                ? recommendFriendMap.get(friends.get(i).get(0)) + 10 : 10);
            }
        }
        return recommendFriendMap;
    }

    public static HashMap<String,Integer> visitTimeline(HashSet<String> friendSet,
                                                        HashMap<String,Integer> recommendFriendMap,
                                                        List<String> visitors) {

        for(int i = 0; i < visitors.size(); i++)
        {
            if(!friendSet.contains(visitors.get(i)))
            {
                recommendFriendMap.put(visitors.get(i),
                        recommendFriendMap.containsKey(visitors.get(i))
                                ? recommendFriendMap.get(visitors.get(i)) + 1 : 1);
            }
        }
        return recommendFriendMap;
    }

    public static List<Map.Entry<String,Integer>> sortRecommendFriendMap(HashMap<String,Integer> recommendFriendMap) {
        List<Map.Entry<String,Integer>> sortingRecommendFriend = new LinkedList<>(recommendFriendMap.entrySet());
        Collections.sort(sortingRecommendFriend, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return sortingRecommendFriend;
    }

    public static List<String> getRecommendFriend(HashMap<String,Integer> recommendFriendMap) {
        List<String> recommendfriend = new ArrayList<>();
        List<Map.Entry<String,Integer>> sortingRecommendFriend = sortRecommendFriendMap(recommendFriendMap);
        int resultSize = sortingRecommendFriend.size() <= 5 ? sortingRecommendFriend.size() : 5;
        for(int i = 0; i < resultSize; i++) {
            recommendfriend.add(sortingRecommendFriend.get(i).getKey());
        }
        return recommendfriend;
    }

    public static List<String> getResult(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> friendSet = makeFriendSet(user, friends);
        HashMap<String,Integer> recommendFriendMap = knowWithUser(friendSet, user, friends);
        recommendFriendMap = visitTimeline(friendSet,recommendFriendMap,visitors);
        List<String> result = getRecommendFriend(recommendFriendMap);

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getResult(user, friends, visitors);
        return answer;
    }
}
