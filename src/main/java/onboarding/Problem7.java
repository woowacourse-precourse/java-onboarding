package onboarding;

import java.util.*;
//(3차 리팩토링) 기능 목록
// (List<List<String>> friends 를 한번만 순회 하기 위해 변경함)
//(변경 전) 1. friends돌며 userFriend Set 생성 -> friends돌며 userFriend의 friend리스트 형성 -> friendmap 완성
// 1. friendMap 형성 -> 2. friends돌며 친구 사이 추가하기 ->3.user(key)로 userFriend리스트 생성

public class Problem7 {
    public static int ACQUAINTANCE_POINT = 10;
    public static int VISITOR_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //1. 친구 맵 만들기
        Map<String, List<String>> friendMap = createFriendMap(friends);
        //2. user의 친구 리스트 뽑기 (user가 없으면 빈 리스트)
        List<String> userFriendList = friendMap.getOrDefault(user, Collections.emptyList());

        //3. 추천 맵 만들기.
        Map<String,Integer> recommendFriendPoint = new HashMap<>();
        //4. 아는사이, 방문자 추가하고 점수 주기.
        recommendAcquaintance(user, userFriendList,friendMap, recommendFriendPoint);
        recommendVisitors(user, userFriendList, visitors, recommendFriendPoint);

        //체크
        System.out.println(recommendFriendPoint);

        //5. 정렬한 리스트 제공
        return createRecommendList(recommendFriendPoint);
    }

    //1. 친구 맵 만들기
    public static Map<String, List<String>> createFriendMap (List<List<String>> friends){
        Map<String, List<String>> friendMap = new HashMap<>();
        for(List<String> relation : friends){
            String userA =  relation.get(0) ,userB = relation.get(1);
            addUserToFriendMap(userA, userB, friendMap); //각 유저마다 friendlist friend맵에 추가하기
            addUserToFriendMap(userB, userA, friendMap);
        }

        return friendMap;
    }

    //2. 친구- 친구 리스트 연결하기 (user, 상대. 상대를 user의 arraylist에 넣기)
    public static void addUserToFriendMap(String user, String myFriend, Map<String, List<String>> friendMap){
        List<String> myFriendList = friendMap.getOrDefault(user, new ArrayList<>());
        myFriendList.add(myFriend);
        friendMap.put(user, myFriendList);
    }




    //4. 추천Map에 친구의 아는 사람 넣기
    public static void recommendAcquaintance(String user, List<String> userFriendList, Map<String,List<String>> friendMap, Map<String,Integer> recommendFriendPoint){
        if (userFriendList.isEmpty()) return;
        for(String userFriend : userFriendList){
            List<String> myFriendList = friendMap.getOrDefault(userFriend, Collections.emptyList());

            for(String friend : myFriendList){
                if(friend.equals(user)) continue; //user본인인 경우
                if(userFriendList.contains(friend)) continue;  // user의 친구인 경우
                if(recommendFriendPoint.containsKey(friend)){
                    recommendFriendPoint.replace(friend,recommendFriendPoint.get(friend)+ACQUAINTANCE_POINT);
                    continue;
                }
                recommendFriendPoint.put(friend, ACQUAINTANCE_POINT);
            }
        }
    }



    //5. 방문자 추천하기 (user본인이나 친구가 아닌경우만)
    public static void recommendVisitors(String user, List<String> userFriends, List<String> visitors, Map<String,Integer> recommendFriendPoint){
        for(String visitor : visitors){
            if (visitor.equals(user)) continue;
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