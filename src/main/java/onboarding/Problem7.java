package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private final static int LEFT_FRIEND = 0;
    private final static int RIGHT_FRIEND = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = List.of("");
        List<String> everyFriendList = makeEveryFriendsList(user,friends);
        List<String> alreadyFriends = findAlreadyFriends(user,friends);
        List<String> notFriends = findNotFriends(everyFriendList,alreadyFriends);
        HashMap<String,Integer> friendScore = makeFriendsScore(alreadyFriends,notFriends,friends);
        HashMap<String,Integer> visitorScore = makeVisitorScore(visitors,alreadyFriends);
        HashMap<String,Integer> totalScore = makeTotalScore(friendScore,visitorScore);
        List<Map.Entry<String, Integer>> recommendFriendList = sortRecommendFriend(totalScore);
        return makeRecommendFriendList(user, recommendFriendList);
    }

    private static List<String> makeEveryFriendsList(String user, List<List<String>> friends){
        List<String> FriendList = new ArrayList<>();
        for(List<String> friend : friends){
            for(String name:friend){
                if(name!=user && !FriendList.contains(name))
                    FriendList.add(name);
            }
        }
        return  FriendList;
    }

    private  static List<String> findAlreadyFriends(String user,List<List<String>> friends){
        List<String> alreadyFriend = new ArrayList<>();
        for(List<String> friend : friends){
            if(friend.get(LEFT_FRIEND) == user) {
                alreadyFriend.add(friend.get(RIGHT_FRIEND));
            }
            if(friend.get(RIGHT_FRIEND) == user) {
                alreadyFriend.add(friend.get(LEFT_FRIEND));
            }
        }
        return alreadyFriend;
    }

    private static List<String> findNotFriends(List<String> everyFriendList,List<String> alreadyFriends){
        List<String> notFriends = new ArrayList<>();
        for(String name : alreadyFriends){
            everyFriendList.remove(name);
        }
        notFriends = everyFriendList;
        return notFriends;
    }

    private static HashMap<String,Integer> makeFriendsScore(List<String> alreadyFriends,
                                                            List<String> notFriends,
                                                            List<List<String>> friends){
        HashMap<String,Integer> friendScore = new HashMap<>();
        for(List<String> friend : friends){
            if(alreadyFriends.contains(friend.get(LEFT_FRIEND)))
                if(notFriends.contains(friend.get(RIGHT_FRIEND)))
                    friendScore.put(friend.get(RIGHT_FRIEND),
                            friendScore.getOrDefault(friend.get(RIGHT_FRIEND),0)+10);

            if(alreadyFriends.contains(friend.get(RIGHT_FRIEND)))
                if(notFriends.contains(friend.get(LEFT_FRIEND)))
                    friendScore.put(friend.get(LEFT_FRIEND),
                            friendScore.getOrDefault(friend.get(LEFT_FRIEND),0)+10);

        }
        return friendScore;
    }

    private static HashMap<String,Integer> makeVisitorScore(List<String> visitors, List<String> alreadyFriends){
        HashMap<String,Integer> visitorScore = new HashMap<>();
        for(String name : visitors){
            if(!alreadyFriends.contains(name))
                visitorScore.put(name, visitorScore.getOrDefault(name,0)+1);
        }
        return visitorScore;
    }

    private static HashMap<String,Integer> makeTotalScore(HashMap<String,Integer> friendScore,
                                                          HashMap<String,Integer> visitorScore){
        friendScore.forEach((key, value) -> visitorScore.merge(key, value, (v1, v2) -> v1 + v2));
        return visitorScore;
    }

    private static List<Map.Entry<String, Integer>> sortRecommendFriend(Map<String, Integer> userScore) {
        List<Map.Entry<String, Integer>> recommendFriendList = new ArrayList<>(userScore.entrySet());
        recommendFriendList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });
        return recommendFriendList;
    }

    private static List<String> makeRecommendFriendList(String user,
                                                        List<Map.Entry<String, Integer>> recommendFriend) {
        return recommendFriend.stream()
                .filter(key -> !user.equals(key.getKey()))
                .filter(value -> value.getValue() != 0)
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }
}

