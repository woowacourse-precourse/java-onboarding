package onboarding;

import java.util.*;
// 이미 친구인 경우 0점
// 친구의 친구인 경우 10점 겹친 친구도 +10점


public class Problem7 {

    static HashMap<String, ArrayList<String>> addPeople(List<List<String>> friends){
        HashMap<String,ArrayList<String>> Friend = new HashMap<>();
        String friendName;
        String friendName2;
        for(List<String>friend:friends)
        {
            friendName = friend.get(0);
            friendName2 = friend.get(1);

            ArrayList<String> friend_list1 = Friend.getOrDefault(friendName,new ArrayList<String>());
            friend_list1.add(friendName2);
            Friend.put(friendName, friend_list1);

            ArrayList<String> friend_list2 = Friend.getOrDefault(friendName2, new ArrayList<String>());
            friend_list2.add(friendName);
            Friend.put(friendName2,friend_list2);
        }
        return Friend;
    }


    static HashMap<String,Integer> recomendFriendScore(String user,ArrayList<String> user_friend, HashMap<String,ArrayList<String>> Friend)
    {
        HashMap<String,Integer> friend_score = new HashMap<String,Integer>();
        ArrayList<String> friendOfFriends;
        String userFriendName = null;
        String friendFriends_name = null;
        int friend_score_temp;


        for(int i = 0; i < user_friend.size() ; i++){
            userFriendName = user_friend.get(i);
            friendOfFriends = Friend.get(userFriendName);
            for(int k = 0 ; k < friendOfFriends.size() ; k++){
                friendFriends_name = friendOfFriends.get(k);
                if(!user.equals(friendFriends_name))
                {
                    friend_score_temp = friend_score.getOrDefault(friendFriends_name, 0) + 10;
                    friend_score.put(friendFriends_name, friend_score_temp);
                }
            }
        }
        return friend_score;
    }

    static HashMap<String,Integer> Score_Visit(HashMap<String,Integer> friend_score,List<String> visitors){
        int friend_score_temp;

        for(String visitor : visitors){
            friend_score_temp = friend_score.getOrDefault(visitor,0) + 1;
            friend_score.put(visitor,friend_score_temp);
        }
        return friend_score;
    }
    static List<String> recommendFriends( HashMap<String,Integer> friend_score,List<String> friend){

        List<String> RecommendFrind = new ArrayList<String>();
        Set<String> key = friend_score.keySet();
        String name = null;

        for(int i = 0 ; i < friend.size() ; i++){
            friend_score.put(friend.get(i),0); //원래 친구 점수 삭제
        }

        for(Iterator<String> i = key.iterator();i.hasNext();){
            name = i.next();
            if(friend_score.get(name) > 0) {
                RecommendFrind.add(name);
            }
            if(RecommendFrind.size() == 5) break;
        }
        return RecommendFrind;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, ArrayList<String>> people = addPeople(friends);
        ArrayList<String> user_friend = people.get(user);
        HashMap<String,Integer> friend_score = recomendFriendScore(user,user_friend,people);
        friend_score = Score_Visit(friend_score,visitors);
        List<String> answer = recommendFriends(friend_score,people.get(user));
        return answer;
    }
}