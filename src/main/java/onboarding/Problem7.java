package onboarding;

import java.util.*;

public class Problem7 {

    //<유저 : 친구목록>인 맵
    private static HashMap<String, HashSet<String>> friendMap = new HashMap<>();
    //<유저 : 점수>인 맵
    private static HashMap<String, Integer> scoreMap = new HashMap<>();
    // 내 이름
    private static String myName;
    // 이미 친구
    private static HashSet<String> userFriend;
    // 추천 명단
    private static List<String> answer = new LinkedList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //class 내에서 정적 변수로 쓰기 위해서 초기화
        myName = user;
        //친구 관계 짓기
        setFriendMap(friends);
        //내친구 목록
        userFriend = friendMap.get(myName);
        //친구 관계로 인한 점수
        friendScore();
        //방문으로 인한 점수
        visitScore(visitors);
        //점수로 추천
        recommendFriend();
        return answer;
    }

    private static void recommendFriend() {
        
    }


    //친구 List를 읽는 메소드
    private static void setFriendMap(List<List<String>> friends) {
        String userA, userB;
        for (int i = 0; i < friends.size(); i++) {
            userA = friends.get(i).get(0);
            userB = friends.get(i).get(1);
            mappingFriend(userA, userB);
            mappingFriend(userB, userA);
        }
    }
    //두 사람을 친구로 맺어주는 메소드
    private static void mappingFriend(String userA, String userB) {
        if (friendMap.containsKey(userA)) {
            friendMap.get(userA).add(userB);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(userB);
            friendMap.put(userA, set);
        }
    }

    //친구 관계로 인한 점수
    private static void friendScore() {
        //친구의 친구 점수 추가
        for (String friend : userFriend) {
            // 친구의 친구들
            HashSet<String> friendFriends = friendMap.get(friend);
            for (String friendFriend : friendFriends) {
                addScore(friendFriend, 10);
            }
        }
    }

    //방문으로 인한 점수
    private static void visitScore(List<String> visitors) {
        //방문자 점수 추가
        for (String visitor : visitors) {
            addScore(visitor, 1);
        }
    }

    //점수를 주는 메소드
    private static void addScore(String user, int score){
        //이미 친구가 아니고, 자기자신이 아니라면 score 추가
        if (!userFriend.contains(user) && !user.equals(myName)) {
            scoreMap.put(user, scoreMap.getOrDefault(user, 0) + score);
        }
    }

}
