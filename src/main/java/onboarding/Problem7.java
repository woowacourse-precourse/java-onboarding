package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> recommendFriends = new HashMap<>();
    public static List<String> compareScore(List<String> answer){
            answer.sort(((o1, o2) -> {
                if(recommendFriends.get(o2).compareTo(recommendFriends.get(o1))==0)
                    return o1.compareTo(o2);
                else
                    return recommendFriends.get(o2).compareTo(recommendFriends.get(o1));
            }));
            while(answer.size()>=6) {
                answer.remove(answer.size() - 1);
            }

            return answer;
    }
    public static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(1).equals(user))
                userFriends.add(friends.get(i).get(0));
        }
        return userFriends;
    } //user의 친구 넣기

    public static void addUserScore(int index, String friendName) {
        if (index == 0) { //10씩 더하기
            recommendFriends.merge(friendName, 10, Integer::sum);
        }else{
            recommendFriends.merge(friendName, 1, Integer::sum);
        }
    }

    public static boolean isFriendOrUser(String s, List<String> userFriend, String user){
        if(s.equals(user))
            return true;
        for(int i=0;i<userFriend.size();i++){
            if(s.equals(userFriend.get(i)))
                return true;
        }
        return false;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = findUserFriends(user, friends);
        System.out.println("userFriend:"+userFriends); // O

        for (int i = 0; i < friends.size(); i++){
            if(!isFriendOrUser(friends.get(i).get(1), userFriends, user))
                addUserScore(0, friends.get(i).get(1));
        }

        for(int i=0;i<visitors.size();i++){
            if(!isFriendOrUser(visitors.get(i), userFriends, user))
                addUserScore(1, visitors.get(i));
        }

        List<String> answer=new ArrayList<>(recommendFriends.keySet());

        answer=compareScore(answer);

        //최대 다섯명
        return answer;

    }
}