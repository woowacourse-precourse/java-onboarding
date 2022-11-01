package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static HashMap<String, Integer> recommend = new HashMap<>();

    public static List<String> friendsScore(String user, List<List<String>> friends, List<String> visitors){
        ArrayList<String> friendList = new ArrayList<>();

        for(List<String> friend : friends){ // 유저와 친구인 id를 friendList에 추가
            if(friend.get(0).equals(user))
                friendList.add(friend.get(1));
            else if(friend.get(1).equals(user))
                friendList.add(friend.get(0));
        }

        for(List<String> f : friends){
            for(String fl : friendList){ // 유저의 친구와 친구가 되어있는 id를 friendList에 추가
                if(f.get(0).equals(fl)&&!f.get(1).equals(user))
                    recommend.put(f.get(1), recommend.containsKey(f.get(1)) ? recommend.get(f.get(1))+10 : 10);
                else if(f.get(1).equals(fl)&&!f.get(0).equals(user))
                    recommend.put(f.get(0), recommend.containsKey(f.get(0)) ? recommend.get(f.get(1))+10 : 10);
            }
        }return visitorsScore(visitors, friendList);

    }
    public static List visitorsScore(List<String> visitors, List<String> friendList){

        for(String visitor : visitors){ // 유저의 친구가 아니면서 visitor인 경우 friendList에 추가
            if(!friendList.contains(visitor))
                recommend.put(visitor, recommend.containsKey(visitor) ? recommend.get(visitor)+1 : 1);
        }
        return sorting();
    }

    public static List sorting(){
        List<String> recommendFriends = new ArrayList<>();
        List<String> listOfName = new ArrayList<>(recommend.keySet());

        listOfName.sort((o1, o2) -> {
            if(recommend.get(o1).equals(recommend.get(o2))){ // 점수가 같다면
                return o1.compareTo(o2); // 알파벳 기준으로 정렬
            }
            return recommend.get(o2).compareTo(recommend.get(o1)); // 점수 기준으로 정렬
        });

        if(listOfName.size() > 5){ // 추천친구가 5명 이상인 경우
            for(int i = 0; i < 5; i++)
                recommendFriends.add(listOfName.get(i));
        }else // 추천친구가 5명 이하인 경우
            recommendFriends.addAll(listOfName);
        return recommendFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List answer = friendsScore(user, friends, visitors);
        return answer;
    }
}