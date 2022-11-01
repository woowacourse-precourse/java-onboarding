package onboarding;

import java.net.Inet4Address;
import java.util.*;

public class Problem7 {
    public static List<String> getAll(List<List<String>> friends, List<String> visitors) {
        List<String> allName = new ArrayList<>();

        for(int i=0;i<friends.size();i++) {
            if(!allName.contains(friends.get(i).get(0))) {
                allName.add(friends.get(i).get(0));
            }
            if(!allName.contains(friends.get(i).get(1))) {
                allName.add(friends.get(i).get(1));
            }
        }
        for(String visitor: visitors) {
            if(!allName.contains(visitor)) {
                allName.add(visitor);
            }
        }
        return allName;
    }
    public static List<Integer> setScore(List<String> allName) {
        List<Integer> allScore = new ArrayList<>();

        for (int i=0;i<allName.size();i++) {
            allScore.add(0);
        }
        return allScore;
    }
    public static List<String> getFriend(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for(int i=0;i<friends.size();i++) {
            if(friends.get(i).contains(user)) {
                if(friends.get(i).get(0).equals(user)) { userFriends.add(friends.get(i).get(1));}
                else {userFriends.add(friends.get(i).get(0));}
            }
        }
        return userFriends;
    }
    public static List<Integer> knowWithFriendScore(String user, List<String> allName, List<Integer> allScore, List<List<String>> friends, List<String> userFriends) {
        for(int i=0;i<friends.size();i++) {
            for(int j=0;j<userFriends.size();j++) {
                String user_friends_name = userFriends.get(j);
                if(friends.get(i).contains(user_friends_name)) {
                    if(friends.get(i).get(0).equals(user_friends_name) && !(friends.get(i).get(1).equals(user))) {
                        int score = allScore.get(allName.indexOf(friends.get(i).get(1))) + 10;
                        allScore.set(allName.indexOf(friends.get(i).get(1)),score);
                    }
                    else if (friends.get(i).get(1).equals(user_friends_name) && !(friends.get(i).get(0).equals(user))){
                        int score = allScore.get(allName.indexOf(friends.get(i).get(0))) + 10;
                        allScore.set(allName.indexOf(friends.get(i).get(0)),score);
                    }
                }
            }
        }
        return allScore;
    }
    public static List<Integer> VisitorScore(List<String> visitors, List<String> allName, List<Integer> allScore) {
        for(String visitor: visitors) {
            int score = allScore.get(allName.indexOf(visitor)) + 1;
            allScore.set(allName.indexOf(visitor),score);
        }
        return allScore;
    }

    public static List<String> recommendFriend(List<String> allName, List<Integer> allScore, List<String> userFriends) {
        int count = 0;
        List<String> res = new ArrayList<>();

        while(count < 5) {
            if(allName.size() == 0) { break; }
            int score = Collections.max(allScore);
            String name = allName.get(allScore.indexOf(score));
            allName.remove(name);
            allScore.remove(Collections.max(allScore));
            if(userFriends.contains(name) || score == 0) { continue; }
            else { res.add(name); count++; }
        }
        return res;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> allName = getAll(friends, visitors);
        List<Integer> allScore = setScore(allName);
        List<String> userFriends = getFriend(user, friends);
        allScore = knowWithFriendScore(user, allName, allScore, friends, userFriends);
        allScore = VisitorScore(visitors, allName, allScore);
        List<String> answer = recommendFriend(allName, allScore, userFriends);

        return answer;
    }
}