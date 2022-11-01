package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static HashMap<String, Integer> recommend = new HashMap<>();

    public static List<String> friendsScore(String user, List<List<String>> friends, List<String> visitors){
        ArrayList<String> friendList = new ArrayList<>();

        for(List<String> friend : friends){
            if(friend.get(0).equals(user))
                friendList.add(friend.get(1));
            else if(friend.get(1).equals(user))
                friendList.add(friend.get(0));
        }

        for(List<String> f : friends){
            for(String fl : friendList){
                if(f.get(0).equals(fl)&&!f.get(1).equals(user))
                    recommend.put(f.get(1), recommend.containsKey(f.get(1)) ? recommend.get(f.get(1))+10 : 10);
                else if(f.get(1).equals(fl)&&!f.get(0).equals(user))
                    recommend.put(f.get(0), recommend.containsKey(f.get(0)) ? recommend.get(f.get(1))+10 : 10);
            }
        }return visitorsScore(visitors, friendList);

    }
    public static List visitorsScore(List<String> visitors, List<String> friendList){

        for(String visitor : visitors){
            if(!friendList.contains(visitor))
                recommend.put(visitor, recommend.containsKey(visitor) ? recommend.get(visitor)+1 : 1);
        }
        return sorting();
    }

    public static List sorting(){
        List<String> recommendFriends = new ArrayList<>();
        List<String> listOfName = new ArrayList<>(recommend.keySet());

        listOfName.sort((o1, o2) -> {
            if(recommend.get(o1).equals(recommend.get(o2))){
                return o1.compareTo(o2);
            }
            return recommend.get(o2).compareTo(recommend.get(o1));
        });

        if(listOfName.size() > 5){
            for(int i = 0; i < 5; i++)
                recommendFriends.add(listOfName.get(i));
        }else
            recommendFriends.addAll(listOfName);
        return recommendFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List answer = friendsScore(user, friends, visitors);
        return answer;
    }
}