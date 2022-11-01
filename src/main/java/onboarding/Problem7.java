package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> recommendList = new HashMap<>();

        recommendList = findUserFriend(user, friends, visitors);
        answer = new ArrayList<>(recommendList.keySet());

        return answer;
    }

    private static HashMap<String, Integer> findUserFriend(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> userFriends = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                int index = (1 + friend.indexOf(user)) % 2;
                userFriends.add(friend.get(index));
            }
        }
        return recommendFriend(user, userFriends, friends, visitors);
    }

    private static HashMap<String, Integer> recommendFriend(String user, HashSet<String> userFriends, List<List<String>> friends, List<String> visitors){
        HashMap<String, Integer> recommendList = new HashMap<>();
        for(List<String> friend : friends){
            String leftFriend = friend.get(0);
            String rightFriend = friend.get(1);
//            System.out.println(rightFriend);
            if (userFriends.contains(leftFriend) && rightFriend != user){
                if(recommendList.containsKey(rightFriend)){
                    int score = recommendList.get(rightFriend) + 10;
                    recommendList.put(rightFriend, score);
                    continue;
                }
                recommendList.put(rightFriend, 10);
            }
            else if (userFriends.contains(rightFriend) && leftFriend != user){
                if(recommendList.containsKey(leftFriend)){
                    int score = recommendList.get(leftFriend) + 10;
                    recommendList.put(leftFriend, score);
                    continue;
                }
                recommendList.put(leftFriend, 10);
            }
        }
        return scoreVisitors(recommendList, visitors, userFriends);
    }

    private static HashMap<String, Integer> scoreVisitors(HashMap<String, Integer> recommendList, List<String> visitors, HashSet<String> userFriends){
        for(String visitor : visitors){
            if (!userFriends.contains(visitor)){
                if(recommendList.containsKey(visitor)){
                    int score = recommendList.get(visitor) + 1;
                    recommendList.put(visitor, score);
                    continue;
                }
                recommendList.put(visitor, 1);
            }

        }
        System.out.println(recommendList);
        return recommendList;

    }
}
