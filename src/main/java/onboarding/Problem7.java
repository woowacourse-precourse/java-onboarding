package onboarding;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> alreadyFriends = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++)
        {
            for(int j = 0; j < 2; j++)
            {
                if(friends.get(i).get(j).equals(user))
                {
                    int index = j != 0 ? 0 : 1;
                    alreadyFriends.add(friends.get(i).get(index));
                }
            }
        }

        List<String> answer = RecommendFriends(RelationFriends(user, friends, alreadyFriends), VisitFriends(visitors, alreadyFriends));
        return answer;
    }
    private static List<String> RelationFriends(String user, List<List<String>> friends, List<String> alreadyFriends)
    {
        List<String> recommendFriends = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(String friend : alreadyFriends)
                {
                    if(friends.get(i).get(j).equals(friend))
                    {
                        int index = j != 0 ? 0 : 1;
                        String recommendFriend = friends.get(i).get(index);
                        if(recommendFriend.equals(user) || recommendFriends.contains(recommendFriend))
                            continue;
                        recommendFriends.add(recommendFriend);
                    }
                }
            }
        }
        return recommendFriends;
    }

    private static List<String> VisitFriends(List<String> visitors, List<String> alreadyFriends)
    {
        ArrayList<String> excludeVistors = new ArrayList<>();
        for(String visitor : visitors)
        {
            excludeVistors.add(visitor);
        }

        for(String alreadyFriend : alreadyFriends)
        {
            for(int i = 0; i < excludeVistors.size(); i++)
            {
                if(excludeVistors.get(i).equals(alreadyFriend))
                    excludeVistors.remove(i);
            }
        }

        return excludeVistors;
    }

    private static List<String> RecommendFriends(List<String> relationFriends, List<String> visitFriends)
    {
        Map<String, Integer> recommendFriendsMap = new HashMap<>();
        int score = 0;
        for(String relationFriend : relationFriends)
        {
            score = 10;
            if(visitFriends.contains(relationFriend))
            {
                for(int i = 0; i < visitFriends.size(); i++)
                {
                    if(visitFriends.get(i).equals(relationFriend))
                        score += 1;
                }
                visitFriends.remove(relationFriend);
            }
            
            recommendFriendsMap.put(relationFriend, score);
        }

        for(String visitFriend : visitFriends)
        {
            score = 1;
            for(String key : recommendFriendsMap.keySet())
            {
                if(key.equals(visitFriend))
                    score = recommendFriendsMap.get(key) + 1;
            }
            
            recommendFriendsMap.put(visitFriend, score);
        }

        List<String> resultList = new ArrayList<>();
        int max = 0;
        String maxKey = "";
        for(String key : recommendFriendsMap.keySet())
        {
            int value = recommendFriendsMap.get(key);
            if(value == 0)
             continue;

            if(value > max)
            {
                max = value;
                maxKey = key;
                resultList.add(0, key);
            }
            else if(value == max)
            {
                int index = resultList.indexOf(maxKey);
                ArrayList<String> names = new ArrayList<>();
                names.add(key);
                names.add(maxKey);
                Collections.sort(names);
                resultList.remove(index);
                resultList.add(index, names.get(0));
                resultList.add(index + 1, names.get(1));
            }
            else
            {
                resultList.add(key);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        System.out.println(solution(user,friends, visitors).toString());
    }
}
