package onboarding;

import java.util.*;

public class Problem7 {

    /*
    모든 사용자의 친구 리스트 만들기
     */
    static Map<String, Set<String>> findFriends(List<List<String>> friends){
        Map<String, Set<String>> friendsList = new HashMap<>();
        for(int idx = 0; idx < friends.size(); idx++){
            String user1Name = friends.get(idx).get(0);
            String user2Name = friends.get(idx).get(1);
            Set<String> curFriendsList;
            //user1
            if(friendsList.containsKey(user1Name)){
                curFriendsList = friendsList.get(user1Name);
                curFriendsList.add(user2Name);
            }
            else{
                Set<String> newFriendList = new HashSet<>();
                newFriendList.add(user2Name);
                friendsList.put(user1Name, newFriendList);
            }
            //user2
            if(friendsList.containsKey(user2Name)){
                curFriendsList = friendsList.get(user2Name);
                curFriendsList.add(user1Name);
            }
            else{
                Set<String> newFriendList = new HashSet<>();
                newFriendList.add(user1Name);
                friendsList.put(user2Name, newFriendList);
            }
        }
        return friendsList;
    }

    /*
    친구의 친구 저장
     */
    static Set<String> waveOfFriends(List<List<String>> friends, String user){
        Map<String, Set<String>> friendsList = findFriends(friends);
        List<String> userFriends = new ArrayList<>(friendsList.get(user));
        Set<String> friendOfFriend = new HashSet<>();

        for(int idx = 0; idx < userFriends.size(); idx++){
            String friendName = userFriends.get(idx);
            List<String> friendOfFriendList = new ArrayList<>(friendsList.get(friendName));
            for(int friendIdx = 0; friendIdx < friendOfFriendList.size(); friendIdx++){
                String friendOfFriendName = friendOfFriendList.get(friendIdx);
                if(friendOfFriendName == user) continue; //본인일 경우 x
                if(userFriends.contains(friendOfFriendName)) continue; //이미 친구일 경우 x
                friendOfFriend.add(friendOfFriendName);
            }
            if(friendName == user) continue;
        }
        return friendOfFriend;
    }

    /*
    친구의 친구 10점 부여
     */
    static Map<String, Integer> calFriendOfFriend(List<List<String>> friends, String user){
        List<String> friendOfFriend = new ArrayList<>(waveOfFriends(friends, user));
        Map<String, Integer> recommendFriendsList = new HashMap<>();

        for(int idx = 0; idx < friendOfFriend.size(); idx++){
            String name = friendOfFriend.get(idx);
            recommendFriendsList.put(name, 10);
        }
        return recommendFriendsList;
    }
    
    /*
    방문자 1점 부여
     */
    static  Map<String, Integer> calVisitors(List<List<String>> friends, String user, List<String> visitors){
        Map<String, Integer> recommendFriendsList = calFriendOfFriend(friends, user);
        Map<String, Set<String>> friendsList = findFriends(friends);
        List<String> userFriends = new ArrayList<>(friendsList.get(user));

        for(int idx = 0; idx < visitors.size(); idx++){
            String visitorName = visitors.get(idx);
            if(recommendFriendsList.containsKey(visitorName))
                recommendFriendsList.put(visitorName,recommendFriendsList.get(visitorName) + 1);
            else{
                if(userFriends.contains(visitorName)) continue;
                recommendFriendsList.put(visitorName, 1);
            }
        }
        return recommendFriendsList;
    }

    static List<String> sortRecommendFriendsList(List<List<String>> friends, String user, List<String> visitors){
        Map<String, Integer> recommendFriendsList = calVisitors(friends, user, visitors);

        List<String> keySet = new ArrayList<>(recommendFriendsList.keySet());
        //이름순 정렬
        Collections.sort(keySet);
        //추천도 정렬
        Collections.sort(keySet,
                            (o1, o2) -> (recommendFriendsList.get(o2).compareTo(recommendFriendsList.get(o1))));

        List<String> sortedList = new ArrayList<>();
        for(int idx = 0; idx < recommendFriendsList.size(); idx++){
            if(idx == 5) break;
            sortedList.add(keySet.get(idx));
        }
        return sortedList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = sortRecommendFriendsList(friends, user, visitors);
        return answer;
    }
}
