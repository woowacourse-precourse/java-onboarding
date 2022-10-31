package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> findMyFriend(String user, List<List<String>> friends){
        List<String> friedList = new ArrayList<>(Collections.emptyList());
        for(int i = 0; i < friends.size(); i++){
            if(Objects.equals(friends.get(i).get(0), user)){
                friedList.add(friends.get(i).get(1));
            }
            if(Objects.equals(friends.get(i).get(1), user)){
                friedList.add(friends.get(i).get(0));
            }
        }
        return friedList;
    }

    static void cntCloseFriend(String user, Map<String, Integer> recommendList, List<String> friendList, List<List<String>> friends){
        for(int i = 0; i < friends.size(); i++){
            String recommend = "nothing";
            if(Objects.equals(friends.get(i).get(0), user) || Objects.equals(friends.get(i).get(1), user)){
                continue;
            }
            if(friendList.contains(friends.get(i).get(0)) && friendList.contains(friends.get(i).get(1))){
                continue;
            }
            if(friendList.contains(friends.get(i).get(0))){
                recommend = friends.get(i).get(1);
            }
            if(friendList.contains(friends.get(i).get(1))){
                recommend = friends.get(i).get(0);
            }
            if(!Objects.equals(recommend, "nothing")){
                if(recommendList.containsKey(recommend)){
                    recommendList.put(recommend, recommendList.get(recommend) + 10);
                }
                else{
                    recommendList.put(recommend, 10);
                }
            }
        }
    }

    static void cntWatchTimeline(Map<String, Integer> recommendList, List<String> friendList, List<String> visitors){
        for(int i = 0; i < visitors.size(); i++){
            if(recommendList.containsKey(visitors.get(i))){
                recommendList.put(visitors.get(i), recommendList.get(visitors.get(i))+1);
            }
            if((!recommendList.containsKey(visitors.get(i))) &&  !friendList.contains(visitors.get(i))){
                recommendList.put(visitors.get(i), 1);
            }
        }
    }

    static List<String> recommendNewFriends(Map<String, Integer> recommendList){
        List<String> keySet = new ArrayList<>(recommendList.keySet());
        List<String> recommendFriend = new ArrayList<>();
        keySet.sort((o1, o2) -> recommendList.get(o2).compareTo(recommendList.get(o1)));
        for(String key: keySet){
            recommendFriend.add(key);
            if(recommendFriend.size()== 5) break;
        }
        return recommendFriend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();

        List<String> friendList = findMyFriend(user, friends);
        Map<String, Integer> recommendList = new TreeMap<>();
        cntCloseFriend(user, recommendList, friendList, friends);
        cntWatchTimeline(recommendList, friendList, visitors);
        //System.out.println(recommendList);
        //System.out.println(friendList);
        return recommendNewFriends(recommendList);
    }
}
