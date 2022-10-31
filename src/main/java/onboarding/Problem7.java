package onboarding;

import java.util.*;
import java.util.function.Predicate;

public class Problem7 {
    public static int ACQUAINTANCE_POINT = 10;
    public static int VISITOR_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //1. 유저의 친구 set형성하기
        Set<String> userFriend = createUserFriend(user, friends);
        //2. 친구 맵 만들기
        Map<String,List<String>> friendMap = createFriendMap(userFriend, friends);

        //3. 추천 맵 만들기.
        Map<String,Integer> recommendFriendPoint = new HashMap<>();
        //4. 아는사이, 방문자 추가하고 점수 주기.
        recommendAcquaintance(friendMap, recommendFriendPoint);
        recommendVisitors(visitors, userFriend, recommendFriendPoint);

        //5. 정렬한 리스트 제공
        return createRecommendList(recommendFriendPoint);
    }

    //1. 유저의 친구관계 알아내기
    public static Set<String> createUserFriend(String user, List<List<String>> friends) {
        Set<String> userFriend = new HashSet<>();
        for (List<String> f : friends) {         //user이름 포함되면 set에 넣기
            if (f.contains(user)) {
                userFriend.add(f.get(0));
                userFriend.add(f.get(1));
            }
        }
        return userFriend;
    }


    //2. 유저의 친구관계로, 친구 맵 만들기
    public static Map<String,List<String>> createFriendMap(Set<String> userFriends, List<List<String>> friends){
        Map<String,List<String>> friendMap = new HashMap<>();
        for (String friend : userFriends){
            List<String> myFriendList =  createMyFriendList(userFriends, friend, friends);
            friendMap.put(friend,myFriendList);  //수정필요. 친구와, 친구관계로 ->친구 리스트 만들기
        }
        return friendMap;
    }


    //3. 친구의 친구관계 리스트 만들기
    public static List<String> createMyFriendList(Set<String> userFriend, String friend, List<List<String>> friends) {
        ArrayList<String> friendList = new ArrayList<>();

        for(List<String> list : friends){ //friend이름과 같고, userFriend에 속한 user가 아니면 추가
            if (list.get(0).equals(friend) && !userFriend.contains(list.get(1))) friendList.add(list.get(1));
            if (list.get(1).equals(friend) && !userFriend.contains(list.get(0))) friendList.add(list.get(0));
        }
        return friendList;
    }




    //4. 추천리스트에 아는 사이 넣기 : (유저) 프랜드 맵 순회하면서 VALUE꺼내서, 추천리스트에 넣고 점수주기
    public static void recommendAcquaintance(Map<String,List<String>> friendMap, Map<String,Integer> recommendFriendPoint){
        for(Map.Entry<String,List<String>> e : friendMap.entrySet()){
            for(String person : e.getValue()){
                if (recommendFriendPoint.containsKey(person)){
                    recommendFriendPoint.replace(person,recommendFriendPoint.get(person)+ACQUAINTANCE_POINT);
                    continue;
                }
                recommendFriendPoint.put(person, ACQUAINTANCE_POINT);
            }
        }
    }



    //5. 추천리스트에 방문자 횟수 넣기.
    public static void recommendVisitors(List<String> visitors, Set<String> userFriends, Map<String,Integer> recommendFriendPoint){
        for(String visitor : visitors){
            if (userFriends.contains(visitor)) continue;
            if (recommendFriendPoint.containsKey(visitor)){
                recommendFriendPoint.replace(visitor, recommendFriendPoint.get(visitor)+VISITOR_POINT);
                continue;
            }
            recommendFriendPoint.put(visitor,VISITOR_POINT);
        }

    }


    //추천 리스트 정렬하기
    public static List<String> createRecommendList(Map<String,Integer> recommendFriendPoint) {
        List<String> recommendList = new ArrayList<>();

        recommendFriendPoint.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed()
                        .thenComparing(Map.Entry<String,Integer>::getKey))
                .filter(e-> e.getValue()>0)
                .forEach(e->recommendList.add(e.getKey()));

        if(recommendList.size()>5) return recommendList.subList(0,5);
        return recommendList;

    }

}