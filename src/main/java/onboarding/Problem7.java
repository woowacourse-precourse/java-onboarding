package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        System.out.println(solution("mrko",
                Arrays.asList(Arrays.asList("donut", "andole"),Arrays.asList("donut", "jun"),Arrays.asList("donut", "mrko"),
                        Arrays.asList("shakevan","andole"),Arrays.asList("shakevan", "jun"),Arrays.asList("shakevan", "mrko"))
                ,Arrays.asList("bedi", "bedi", "donut", "bedi", "shakevan")));
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Hashtable<String,HashSet<String>> friendsHash = new Hashtable<>(); // 모든 관계를 저장할 해쉬 테이블
        Hashtable<String,Integer> friendRecommendScores = new Hashtable<>(); // 점수를 저장할 해쉬 테이블
        List<String> answer; // 정답

        for (List<String> friend: friends // 모든 친구 관계를 해쉬에 저장하기 위한 반복문
             ) {
            if (!friendsHash.containsKey(friend.get(0))){ // 키 값을 추가하고 새로운 해쉬 셋을 만듬
                friendsHash.put(friend.get(0), new HashSet<>(List.of(friend.get(1))));
            }
            else friendsHash.get(friend.get(0)).add(friend.get(1)); // 아니라면 친구를 추가

            if (!friendsHash.containsKey(friend.get(1))){ // 위와 동일
                friendsHash.put(friend.get(1), new HashSet<>(List.of(friend.get(0))));
            }
            else friendsHash.get(friend.get(1)).add(friend.get(0));
        }

        for (String userFriend: friendsHash.get(user) // 유저의 친구를 확인하기 위한 반복
             ) {
            for (String recommendFriend: friendsHash.get(userFriend) // 친구의 친구를 확인하기 위한 반복
                 ) {
                if (user.equals(recommendFriend) || friendsHash.get(user).contains(recommendFriend)) continue; // 유저라면 무시
                if (friendRecommendScores.containsKey(recommendFriend)) // 이미 프레든스코어해시에 있다면  + 10
                    friendRecommendScores.put(recommendFriend,friendRecommendScores.get(recommendFriend) + 10);
                else
                    friendRecommendScores.put(recommendFriend,10); // 해시에 없다면 키와 밸류 10을 대입
            }
        }

        for (String visitor:visitors // 방문자 확인 반복
             ) {
            if (friendsHash.get(user).contains(visitor)) continue; // 방문자가 유저의 친구라면 친구 추천 점수를 주지 않는다.
            if (friendRecommendScores.containsKey(visitor)) friendRecommendScores.put(visitor,friendRecommendScores.get(visitor) + 1); // 해시에 있다면 +1
            else friendRecommendScores.put(visitor,1); // 해쉬에 없다면 키와 1을 삽입
        }
        List<String> keySet = new ArrayList<>(friendRecommendScores.keySet()); // 정렬을 위한 배열
        keySet.sort(((o1, o2) -> friendRecommendScores.get(o2).compareTo(friendRecommendScores.get(o1)))); // 점수 내림차순 정렬
        if (keySet.size() > 5) answer = keySet.subList(0,5 + 1); // 키가 5개 이상이면 5개 까지 자름
        else answer = keySet; // 아니라면 다 출력
        return answer;
    }
}
